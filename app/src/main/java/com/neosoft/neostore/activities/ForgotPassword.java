package com.neosoft.neostore.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.neosoft.neostore.R;
import com.neosoft.neostore.databinding.ActivityForgotPasswordBinding;
import com.neosoft.neostore.handler.Handler;


/**
 * Created by webwerks1 on 15/3/17.
 */

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityForgotPasswordBinding binding=DataBindingUtil.setContentView(this, R.layout.activity_forgot_password);
        binding.setMyHandler(new Handler());

    }
}
