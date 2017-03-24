package com.neosoft.neostore.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.neosoft.neostore.Handler.Handler;
import com.neosoft.neostore.R;
import com.neosoft.neostore.databinding.ActivityForgotPasswordBinding;
import com.neosoft.neostore.model.ForgotPasswordPOJO;


/**
 * Created by webwerks1 on 15/3/17.
 */

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

	    ActivityForgotPasswordBinding passwordBinding = DataBindingUtil.setContentView( this,R.layout.activity_forgot_password );
	    passwordBinding.setMyHandler( new Handler() );
	    passwordBinding.setForgotPass( new ForgotPasswordPOJO() );

//        ActivityForgotPasswordBinding binding =DataBindingUtil.setContentView( this, R.layout.activity_forgot_password);
//        binding.setMyHandler(new Handler());
//        binding.setForgotPass(new ForgotPasswordPOJO());

    }
}
