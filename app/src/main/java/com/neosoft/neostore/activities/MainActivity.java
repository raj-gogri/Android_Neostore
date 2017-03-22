package com.neosoft.neostore.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neosoft.neostore.Handler.MyHandler;
import com.neosoft.neostore.databinding.ActivityMainBinding;
import com.neosoft.neostore.model.Register;
import com.neosoft.neostore.R;

/**
 * Created by Nidhi on 9/3/17.
 */


public class MainActivity extends AppCompatActivity {


	//	private String first,last,emailId,pass,confirmPass,num,radio1;
	private ActivityMainBinding binding;
//	private RadioButton         radioButton,male,female;
//	private RadioGroup radioGroup;
//	int selectID;
//	String selection;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		//setContentView( R.layout.activity_main );

		binding = DataBindingUtil.setContentView( this, R.layout.activity_main );

		binding.setRegister( new Register() );

		binding.setMyHandler( new MyHandler() );

		binding.setActivity( this );

//		binding.BtnRegister.setOnClickListener( new View.OnClickListener() {
//			@Override
//			public void onClick( View v ) {
//
//				first = binding.getRegister().getFirstName();
//				last = binding.getRegister().getLastName();
//				emailId = binding.getRegister().getEmail();
//				pass = binding.getRegister().getPassword();
//				confirmPass = binding.getRegister().getConfirmPassword();
//				radio1 = binding.getRegister().getGender();
//				num = binding.getRegister().getPhoneNumber();
//
//
//
//				int selectedId = binding.radioGroup.getCheckedRadioButtonId();
//
//				radioButton = (RadioButton) findViewById(selectedId);
//
//				radio1 = radioButton.getText().toString();
//
//
//				if(binding.getRegister().isValid()){
//
//					if(binding.checkBoxConditions.isChecked()){
//
//						if(binding.getRegister().getEmail().matches( getResources().getString( R.string.email_pattern ) )){
//
//
//							userPost();
//
//
//
//
//
//						}else {
//
//							Toast.makeText(getApplicationContext(),"Please enter a valid Email Id",Toast.LENGTH_LONG).show();
//
//
//						}
//
//
//					}else {
//
//						Toast.makeText(getApplicationContext(),"Please check the terms and conditions",Toast.LENGTH_LONG).show();
//					}
//				}else {
//
//					Toast.makeText(getApplicationContext(),"Please fill all the values",Toast.LENGTH_LONG).show();
//				}
//
//
//			}
//		} );
//
//
//
//
//
////		Toolbar toolbar = (Toolbar ) findViewById( R.id.toolbar);
////		setSupportActionBar(toolbar);
////		getSupportActionBar().setDisplayShowTitleEnabled( false );
////		toolbar.setTitle( null );
////		setSupportActionBar(toolbar);
////		ActionBar actionBar = getSupportActionBar();
////		if(actionBar != null)
////			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//	}
//
//
//
//
//	private void clearText() {
//
//		binding.editTextFirstName.setText( "" );
//		binding.editTextLastName.setText( "" );
//		binding.editTextEmail.setText( "" );
//		binding.editTextPassword.setText( "" );
//		binding.editTextConfirmPassword.setText( "" );
//		binding.editTextPhone.setText( "" );
//		binding.checkBoxConditions.setChecked( false );
//
//	}
//
//	private void userPost( ) {
//
//
//		//TODO code for RX Android
//
////		ServiceInterface serviceInterface = ApiClient.getObservableClient( POST_REGISTER_URL ).create( ServiceInterface.class );
////
////
////		Observable< Register > observable = serviceInterface.postUserDetails( first, last, emailId, pass, confirmPass,radio1 ,num );
////
////		observable.subscribeOn( Schedulers.newThread() )
////
////				.observeOn( AndroidSchedulers.mainThread() )
////
////
////				.subscribe( new Subscriber< Register >() {
////					@Override
////					public void onCompleted() {
////
////
////					}
////
////					@Override
////					public void onError( Throwable e ) {
////
////						Log.e( "Failure", e.getMessage() );
////
////
////					}
////
////					@Override
////					public void onNext( Register register ) {
////
////						Log.d( "SUCCESS", register.toString());
////
////
////
////					}
////
////				} );
//
//
//		// TODO code for retrofit
//
//
//		ServiceInterface userService = ApiClient.getClient(getResources().getString( R.string.REGISTER_POST )).create( ServiceInterface.class );
//
//
//		Call<Register> call =  userService.postUserDetails(first, last, emailId, pass, confirmPass,radio1 ,num  );
//
//		call.enqueue( new Callback< Register >() {
//			@Override
//			public void onResponse( Call< Register > call, Response< Register > response ) {
//
//				if(response.isSuccessful()) {
//
//					Register registerNew = response.body();
//
//					Log.d( "success", response.message() );
//
//					Toast.makeText( getApplicationContext(),registerNew.getMessage(),Toast.LENGTH_SHORT ).show();
//
//					clearText();
//
//				}else {
//
//
//					Toast.makeText( getApplicationContext(),"Email Id already exist / Data is missing",Toast.LENGTH_SHORT ).show();
//
//				}
//
//			}
//
//			@Override
//			public void onFailure( Call< Register > call, Throwable t ) {
//
//				Log.e("Failed",t.toString() );
//
//			}
//		} );
	}

}