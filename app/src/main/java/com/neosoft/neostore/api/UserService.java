package com.neosoft.neostore.api;

import com.neosoft.neostore.model.LoginUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by webwerks1 on 19/1/17.
 */

public interface UserService {
    @FormUrlEncoded
    @POST("api/users/register")
    /*Call<User> post(
            @Field("first_name") String firstName,
            @Field("last_name") String lastName,
            @Field("email") String email,
            @Field("password") String password,
            @Field("confirm_password") String confirm_password,
            @Field("gender") String gender,
            @Field("phone_no") String phone_no

    );
*/
    public void postdetails(@Field("first_name") String firstName,
                            @Field("last_name") String lastName,
                            @Field("email") String email,
                            @Field("password") String password,
                            @Field("confirm_password") String confirm_password,
                            @Field("gender") String gender,
                            @Field("phone_no") String phone_no);

    @FormUrlEncoded
    @POST("api/users/login")
    Call<LoginUser> postLogin(
            @Field("email") String email,
            @Field("password") String password

    );

    @FormUrlEncoded
    @POST("api/users/forgot")
    Call<LoginUser> postForgotPass(
            @Field("email") String email

    );

}
