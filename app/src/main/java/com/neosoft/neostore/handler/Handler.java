package com.neosoft.neostore.handler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.neosoft.neostore.R;
import com.neosoft.neostore.activities.ForgotPassword;
import com.neosoft.neostore.activities.MainActivity;
import com.neosoft.neostore.api.ApiClient;
import com.neosoft.neostore.api.UserService;
import com.neosoft.neostore.helper.BaseActivity;
import com.neosoft.neostore.model.ForgotPasswordPOJO;
import com.neosoft.neostore.model.LoginUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by webwerks1 on 10/3/17.
 */

public class Handler {


    private static final String SERVER_URL = "http://staging.php-dev.in:8844/trainingapp/";


    private String userId = "";
    private String userPassword = "";
    private String forgotPassUserId = "";

    public void onLoginClick(final View view, LoginUser user) {

        InputMethodManager inputManager = (InputMethodManager)
                view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        userId = user.getUserName();
        userPassword = user.getPassword();

        if (!user.isValid()) {
            Toast.makeText(view.getContext(), "Enter valid Email id", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(view.getContext(), "Enter password", Toast.LENGTH_SHORT).show();
        } else {
            UserService apiService =
                    ApiClient.getClient(SERVER_URL).create(UserService.class);
            Call<LoginUser> call = apiService.postLogin(userId, userPassword);
            call.enqueue(new Callback<LoginUser>() {
                @Override
                public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                    LoginUser loginResponse = response.body();


                    if (response.isSuccessful()) {
                        Toast.makeText(view.getContext(), "User login is successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(view.getContext(), "User login is unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginUser> call, Throwable t) {
                    // Log error here since request failed
                    Log.d("", t.toString());
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

    public void onSubmitClick(final View view, ForgotPasswordPOJO forgotPasswordPOJO) {

        InputMethodManager inputManager = (InputMethodManager)
                view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        forgotPassUserId = forgotPasswordPOJO.getUserId();
        if (forgotPasswordPOJO.isValid()) {

            UserService apiService =
                    ApiClient.getClient(SERVER_URL).create(UserService.class);
            Call<LoginUser> call = apiService.postForgotPass(forgotPassUserId);
            call.enqueue(new Callback<LoginUser>() {
                @Override
                public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                    LoginUser loginResponse = response.body();


                    if (response.isSuccessful()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                        builder.setMessage("New password sent successfully");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(view.getContext(), MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                view.getContext().startActivity(intent);
                            }
                        });

                        // Create the AlertDialog object and return it
                        builder.create();
                        builder.show();
                    } else {
                        Toast.makeText(view.getContext(), "Email Id does not exist.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginUser> call, Throwable t) {
                    // Log error here since request failed
                    Log.d("", t.toString());
                }
            });

        }else
        {
            Toast.makeText(view.getContext(), "Please enter valid Email Id ", Toast.LENGTH_SHORT).show();
        }
    }
}
