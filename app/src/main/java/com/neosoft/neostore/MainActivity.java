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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
	Register register1 = new Register();
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
				radio1 = binding.radio.toString();
				num = binding.editTextPhone.getText().toString();

				int selectedId = binding.radio.getCheckedRadioButtonId();

				radioButton = (RadioButton) findViewById(selectedId);

				radio1 = radioButton.getText().toString();


				if(binding.getRegister().isValid()){


					userPost();

					clearText();



				}else {


					Toast.makeText(getApplicationContext(),"Please fill all the values",Toast.LENGTH_LONG).show();
				}


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
		binding.checkBoxConditions.setChecked( false );
	}

	private void userPost( ) {


		//TODO code for RX Android

//		ServiceInterface serviceInterface = ApiClient.getObservableClient( POST_REGISTER_URL ).create( ServiceInterface.class );
//
//
//		Observable< Register > observable = serviceInterface.postUserDetails( first, last, emailId, pass, confirmPass,radio1 ,num );
//
//		observable.subscribeOn( Schedulers.newThread() )
//
//				.observeOn( AndroidSchedulers.mainThread() )
//
//
//				.subscribe( new Subscriber< Register >() {
//					@Override
//					public void onCompleted() {
//
//
//					}
//
//					@Override
//					public void onError( Throwable e ) {
//
//						Log.e( "Failure", e.getMessage() );
//
//
//					}
//
//					@Override
//					public void onNext( Register register ) {
//
//						Log.d( "SUCCESS", register.toString());
//
//
//
//					}
//
//				} );


		// TODO code for retrofit


		ServiceInterface userService = ApiClient.getClient( POST_REGISTER_URL ).create( ServiceInterface.class );


		Call<Register> call =  userService.postUserDetails(first, last, emailId, pass, confirmPass,radio1 ,num  );

		call.enqueue( new Callback< Register >() {
			@Override
			public void onResponse( Call< Register > call, Response< Register > response ) {

				Log.d("success",response.message());

			}

			@Override
			public void onFailure( Call< Register > call, Throwable t ) {

				Log.e("Failed",t.toString() );

			}
		} );
	}
}
