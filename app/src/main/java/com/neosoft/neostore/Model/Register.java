package com.neosoft.neostore.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.neosoft.neostore.Responses.ResponseData;


/**
 * Created by webwerks on 9/3/17.
 */

public class Register extends BaseObservable{

	private String firstName;
	private String lastName;;
	private String email;
	private String password;
	private String confirmPassword;
	private String phoneNumber;
	private boolean gender;
	ResponseData responseData;



//	Register(String name1,String name2,String emailNew, String passwordNew, String confirmPass){
//
//		this.firstName = name1;
//		this.lastName = name2;
//		this.email = emailNew;
//		this.password = passwordNew;
//		this.confirmPassword= confirmPass;
//
//
//	}




	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName( String firstName ) {
		this.firstName = firstName;


	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	public void setConfirmPassword( String confirmPassword ) {
		this.confirmPassword = confirmPassword;
	}


	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber( String phoneNumber ) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isGender() {
		return this.gender;
	}

	public void setGender( boolean gender ) {
		this.gender = gender;
	}

	public ResponseData getResponseData() {
		return this.responseData;
	}

	public void setResponseData( ResponseData responseData ) {
		this.responseData = responseData;
	}

	public boolean isValid(){

		return !TextUtils.isEmpty( firstName ) && !TextUtils.isEmpty( lastName ) && !TextUtils.isEmpty( email ) && !TextUtils.isEmpty( password ) && !TextUtils.isEmpty( confirmPassword ) && !TextUtils.isEmpty(phoneNumber);



	}
}
