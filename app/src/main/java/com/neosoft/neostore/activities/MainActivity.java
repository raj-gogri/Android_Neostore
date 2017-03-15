package com.neosoft.neostore.activities;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neosoft.neostore.R;
import com.neosoft.neostore.databinding.ActivityMainBinding;
import com.neosoft.neostore.handler.Handler;
import com.neosoft.neostore.model.LoginUser;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMyHandler(new Handler());
        binding.setMyUser(new LoginUser());

    }
}
