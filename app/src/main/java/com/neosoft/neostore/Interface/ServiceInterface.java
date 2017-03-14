package com.neosoft.neostore.Interface;

import com.neosoft.neostore.Model.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by webwerks on 10/3/17.
 */

public interface ServiceInterface {


//
//	@FormUrlEncoded
//	@POST("api/users/register")
//	rx.Observable<Register> postUserDetails(
//
//			@Field("first_name") String first_name,
//			@Field("last_name") String last_name,
//			@Field("email") String email,
//			@Field("password") String password,
//			@Field("confirm_password") String confirm_password,
//			@Field("gender") String gender,
//			@Field("phone_no") String phone_no
//
//	);

	@FormUrlEncoded
	@POST("api/users/register")
	Call<Register> postUserDetails(

			@Field("first_name") String first_name,
			@Field("last_name") String last_name,
			@Field("email") String email,
			@Field("password") String password,
			@Field("confirm_password") String confirm_password,
			@Field("gender") String gender,
			@Field("phone_no") String phone_no

	);
}
