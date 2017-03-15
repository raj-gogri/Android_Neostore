package com.neosoft.neostore.handler;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.neosoft.neostore.activities.ForgotPassword;
import com.neosoft.neostore.api.ApiClient;
import com.neosoft.neostore.api.UserService;
import com.neosoft.neostore.helper.BaseActivity;
import com.neosoft.neostore.model.LoginUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by webwerks1 on 10/3/17.
 */

public class Handler  {


    private String userId="";
    private String userPassword="";


    private static final String SERVER_URL="http://staging.php-dev.in:8844/trainingapp/";
    public void onLoginClick(final View view, LoginUser user)
    {
        userId=user.getUserName();
        userPassword=user.getPassword();

      if(TextUtils.isEmpty(userId) )
      {
          Toast.makeText(view.getContext(),"enter id",Toast.LENGTH_SHORT).show();
      }

        else if(TextUtils.isEmpty(userPassword))
      {
          Toast.makeText(view.getContext(),"enter pass",Toast.LENGTH_SHORT).show();
      }
        else
      {
          UserService apiService =
                  ApiClient.getClient(SERVER_URL).create(UserService.class);
          Call<LoginUser> call = apiService.postLogin( userId,userPassword );
          call.enqueue(new Callback<LoginUser>() {
              @Override
              public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                  LoginUser loginResponse= response.body();


                  if(response.isSuccessful())
                  {
                      Toast.makeText(view.getContext(),"User login is successful",Toast.LENGTH_SHORT).show();
                  }
                  else
                  {
                      Toast.makeText(view.getContext(),"User login is unsuccessful",Toast.LENGTH_SHORT).show();
                  }
              }

              @Override
              public void onFailure(Call<LoginUser> call, Throwable t) {
                  // Log error here since request failed
                  Log.d("",t.toString());
              }
          });
      }
    }


    public void onForgotPassClick(View view)

    {
        Intent intent = new Intent(view.getContext(), ForgotPassword.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        view.getContext().startActivity(intent);
        //sendToClass(ForgotPassword.class);\

    }

}
