package com.neosoft.neostore;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neosoft.neostore.databinding.ActivityMainBinding;

import com.neosoft.neostore.model.LoginUser;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);



    }
}
