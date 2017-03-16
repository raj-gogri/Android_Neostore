package com.neosoft.neostore.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.neosoft.neostore.R;
import com.neosoft.neostore.activities.ForgotPassword;

/**
 * Created by webwerks1 on 15/3/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getApplicationContext();

    }

    public void sendToClass(Class activity) {
        Intent intent = new Intent(mContext, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(intent);
    }


}
