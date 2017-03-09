package com.neosoft.neostore;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.neosoft.neostore.Model.Register;
import com.neosoft.neostore.databinding.ActivityMainBinding;

import org.stringtemplate.v4.ST;

public class MainActivity extends AppCompatActivity {


	String first,last,emailId,pass,confirmPass,num,group;
	ActivityMainBinding binding;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		//setContentView( R.layout.activity_main );



		binding = DataBindingUtil.setContentView( this,R.layout.activity_main );

		binding.setRegister( new Register() );


		first = binding.editTextFirstName.getText().toString();
		last = binding.editTextLastName.getText().toString();
		emailId = binding.editTextEmail.getText().toString();
		pass = binding.editTextPassword.getText().toString();
		confirmPass = binding.editTextConfirmPassword.getText().toString();
		num = binding.editTextPhone.getText().toString();



//		Toolbar toolbar = (Toolbar ) findViewById( R.id.toolbar);
//		toolbar.setTitle( null );
//		setSupportActionBar(toolbar);
//		ActionBar actionBar = getSupportActionBar();
//		if(actionBar != null)
//			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
}
