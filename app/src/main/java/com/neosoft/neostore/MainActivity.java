package com.neosoft.neostore;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.neosoft.neostore.API.ApiClient;
import com.neosoft.neostore.Interface.ServiceInterface;
import com.neosoft.neostore.Model.Register;
import com.neosoft.neostore.databinding.ActivityMainBinding;

import org.stringtemplate.v4.ST;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


	private String first,last,emailId,pass,confirmPass,num,radio1;
	private ActivityMainBinding binding;
	private RadioButton radioButton,male,female;
	private RadioGroup radioGroup;
	int selectID;
	String selection;
	private static final String POST_REGISTER_URL = "http://staging.php-dev.in:8844/trainingapp/";

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		//setContentView( R.layout.activity_main );

//		radioGroup = (RadioGroup) findViewById( R.id.radio );
//
//		male = (RadioButton ) findViewById( R.id.radioButtonMale );
//
//		female = (RadioButton ) findViewById( R.id.radioButtonFemale );
//
//		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//			@Override
//			public void onCheckedChanged(RadioGroup group, int checkedId) {
//				// find which radio button is selected
//				if(checkedId == R.id.radioButtonMale) {
//
//				    selection = "M";
//
//				} else if(checkedId == R.id.radioButtonFemale) {
//
//					selection = "F";
//				}
//			}
//
//		});


		binding = DataBindingUtil.setContentView( this,R.layout.activity_main );

		binding.setRegister( new Register() );

		binding.BtnRegister.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick( View v ) {

				first = binding.editTextFirstName.getText().toString();
				last = binding.editTextLastName.getText().toString();
				emailId = binding.editTextEmail.getText().toString();
				pass = binding.editTextPassword.getText().toString();
				confirmPass = binding.editTextConfirmPassword.getText().toString();
//				radio1 = radioGroup.toString();
				num = binding.editTextPhone.getText().toString();


				userPost();

				clearText();


			}
		} );



//		Toolbar toolbar = (Toolbar ) findViewById( R.id.toolbar);
//		toolbar.setTitle( null );
//		setSupportActionBar(toolbar);
//		ActionBar actionBar = getSupportActionBar();
//		if(actionBar != null)
//			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}


	private void clearText() {

		binding.editTextFirstName.setText( "" );
		binding.editTextLastName.setText( "" );
		binding.editTextEmail.setText( "" );
		binding.editTextPassword.setText( "" );
		binding.editTextConfirmPassword.setText( "" );
		binding.editTextPhone.setText( "" );
	}

	private void userPost( ) {

		ServiceInterface serviceInterface = ApiClient.getObservableClient( POST_REGISTER_URL ).create( ServiceInterface.class );


		Observable< Register > observable = serviceInterface.postUserDetails( first, last, emailId, pass, confirmPass ,num );

		observable.subscribeOn( Schedulers.newThread() )

				.observeOn( AndroidSchedulers.mainThread() )


				.subscribe( new Subscriber< Register >() {
					@Override
					public void onCompleted() {


					}

					@Override
					public void onError( Throwable e ) {

						Log.e( "Failure", e.getMessage() );


					}

					@Override
					public void onNext( Register register ) {

						Log.d( "SUCCESS", register.toString());


					}

				} );




//		UserService userService = ApiClient.getClient( POST_URL ).create( UserService.class );
//
//
//		Call<Users> call =  userService.post(users.getFirstName(),users.getLastName(),users.getUserEmail(),users.getUserPassword(),users.getConfirmPassword(),users.getUserGender(),users.getUserNumber() );
//
//		call.enqueue( new Callback< Users >() {
//			@Override
//			public void onResponse( Call< Users > call, Response< Users > response ) {
//
//				Log.d("success",response.message());
//
//			}
//
//			@Override
//			public void onFailure( Call< Users > call, Throwable t ) {
//
//				Log.e("Failed",t.toString() );
//
//			}
//		} );
	}
}
