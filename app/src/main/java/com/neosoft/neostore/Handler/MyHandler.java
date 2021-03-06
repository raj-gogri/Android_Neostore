package com.neosoft.neostore.Handler;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.neosoft.neostore.API.ApiClient;
import com.neosoft.neostore.activities.Demo;
import com.neosoft.neostore.Interface.ServiceInterface;
import com.neosoft.neostore.activities.MainActivityLogin;
import com.neosoft.neostore.model.Register;
import com.neosoft.neostore.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nidhi on 15/3/17.
 */

public class MyHandler {

	private String first,last,emailId,pass,confirmPass,num,radio1;
	EditText firstName;
	private int selectedId;
	private RadioButton radioButton;
	private static final String REGISTER_URL = "http://staging.php-dev.in:8844/trainingapp/";

	public void onNavigateButton( View view,Activity activity){

		Intent i = new Intent( view.getContext(), MainActivityLogin.class );
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		view.getContext().startActivity( i );
		transitionAnimation(activity);


	}


	public void onRadioButtonClicked(View view, Register registerNew){


		switch ( view.getId()){
			case R.id.radioButtonMale:
				registerNew.setGender( "Male" );
				Log.e( "Radio Male","male" );
				break;
			case R.id.radioButtonFemale:
				registerNew.setGender( "Female" );
				Log.e( "Radio Female","female" );
				break;
			default:
				registerNew.setGender( "Male" );
		}

	}

	public  void onRegisterBtn( final View view, final Register registerNew ,final Activity activity1){


		first = registerNew.getFirstName();
		last = registerNew.getLastName();
		emailId = registerNew.getEmail();
		pass = registerNew.getPassword();
		radio1 = registerNew.getGender();
		confirmPass = registerNew.getConfirmPassword();
		num = registerNew.getPhoneNumber();


		if(registerNew.isValid()){

			//if(){

				if(registerNew.getEmail().matches( view.getContext().getResources().getString( R.string.email_pattern ) )){


					ServiceInterface userService = ApiClient.getClient(REGISTER_URL ).create( ServiceInterface.class );


					Call<Register> call =  userService.postUserDetails( first, last, emailId, pass, confirmPass, radio1 , num  );

					call.enqueue( new Callback< Register >() {
						@Override
						public void onResponse( Call< Register > call, Response< Register > response ) {

							if(response.isSuccessful()) {

								Register registerNew = response.body();

								Log.d( "success", response.message() );

								Toast.makeText(view.getContext() ,registerNew.getMessage(),Toast.LENGTH_SHORT ).show();

								Intent intent = new Intent( view.getContext(), MainActivityLogin.class );

								view.getContext().startActivity( intent );

								transitionAnimation(activity1);



							}else {

								Toast.makeText( view.getContext(),"Email Id already exist / Data is missing",Toast.LENGTH_SHORT ).show();

							}

						}

						@Override
						public void onFailure( Call< Register > call, Throwable t ) {

							Log.e("Failed",t.toString() );

						}

					} );

				}else {

					Toast.makeText( view.getContext(), "Please enter a valid Email Id", Toast.LENGTH_LONG).show();


				}

//			}else {
//
//				Toast.makeText(view.getContext(),"Please check the terms and conditions",Toast.LENGTH_LONG).show();
//			}
		}else {

			Toast.makeText(view.getContext(),"Please fill all the values",Toast.LENGTH_LONG).show();

		}




	}



	public void transitionAnimation( Activity activity1){

		activity1.overridePendingTransition( R.anim.slide_in_right,R.anim.slide_out_left);

	}



}
