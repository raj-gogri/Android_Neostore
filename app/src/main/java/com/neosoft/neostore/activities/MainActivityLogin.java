package com.neosoft.neostore.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neosoft.neostore.Handler.MyHandler;
import com.neosoft.neostore.R;
import com.neosoft.neostore.databinding.ActivityMainBinding;
import com.neosoft.neostore.model.Register;


public class MainActivityLogin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView( this, R.layout.activity_login);
        binding.setMyHandler(new MyHandler());
	    binding.setRegister(new Register());
	    //TODO : Mayuri Ne Tera Code kharab kiya hai... Maar Usko !! :D :D
    }
}
