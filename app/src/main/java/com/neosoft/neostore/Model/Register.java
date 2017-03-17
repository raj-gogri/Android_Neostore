package com.neosoft.neostore.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.neosoft.neostore.BR;
import com.neosoft.neostore.Responses.ResponseData;


/**
 * Created by Nidhi on 9/3/17.
 */

public class Register extends BaseObservable{

	private String firstName;
	private String lastName;;
	private String email;
	private String password;
	private String confirmPassword;
	private String phoneNumber;
	private String gender;
	private String status;
	private String user_msg;
	private String message;




	@Bindable
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( String firstName ) {
		this.firstName = firstName;
		notifyPropertyChanged( BR.firstName );



	}

	@Bindable
	public String getLastName() {
		return lastName;
	}

	public void setLastName( String lastName ) {
		this.lastName = lastName;
		notifyPropertyChanged( BR.lastName );


	}

	@Bindable
	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
		notifyPropertyChanged( BR.email );

	}

	@Bindable
	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
		notifyPropertyChanged( BR.password );
	}

	@Bindable
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword( String confirmPassword ) {
		this.confirmPassword = confirmPassword;
		notifyPropertyChanged( BR.confirmPassword );
	}


	@Bindable
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber( String phoneNumber ) {
		this.phoneNumber = phoneNumber;
		notifyPropertyChanged( BR.phoneNumber );
	}

	@Bindable
	public String getGender() {
		return this.gender;
	}

	public void setGender( String gender ) {
		this.gender = gender;
		notifyPropertyChanged( BR.gender );
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus( String status ) {
		this.status = status;
	}

	public String getUser_msg() {
		return this.user_msg;
	}

	public void setUser_msg( String user_msg ) {
		this.user_msg = user_msg;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage( String message ) {
		this.message = message;
	}

	public boolean isValid(){

		//String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

		return !TextUtils.isEmpty( firstName ) && !TextUtils.isEmpty( lastName ) && !TextUtils.isEmpty( email ) && !TextUtils.isEmpty( password ) && !TextUtils.isEmpty( confirmPassword ) && !TextUtils.isEmpty(phoneNumber) ;



	}
}