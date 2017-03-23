package com.neosoft.neostore.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.neosoft.neostore.R;
import com.neosoft.neostore.databinding.ActivityLoginBinding;
import com.neosoft.neostore.Handler.Handler;
import com.neosoft.neostore.model.LoginUser;


public class MainActivityLogin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);


	    ActivityLoginBinding binding = DataBindingUtil.setContentView( this, R.layout.activity_login );
	    binding.setMyHandler( new Handler() );
	    binding.setMyUser( new LoginUser() );
//	    binding.setMyHandler(new MyHandler());
//	    binding.setRegister(new Register());
	    //TODO : Mayuri Ne Tera Code kharab kiya hai... Maar Usko !! :D :D
    }
}
