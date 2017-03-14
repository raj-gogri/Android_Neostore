package com.neosoft.neostore.Responses;

/**
 * Created by webwerks on 14/3/17.
 */

public class ResponseData {

	private String message;
	private String user_msg;
	UserRegister data;
	RegisterData registerData;

	public String getMessage() {
		return this.message;
	}

	public void setMessage( String message ) {
		this.message = message;
	}

	public String getUser_msg() {
		return this.user_msg;
	}

	public void setUser_msg( String user_msg ) {
		this.user_msg = user_msg;
	}

	public UserRegister getData() {
		return this.data;
	}

	public void setData( UserRegister data ) {
		this.data = data;
	}

	public RegisterData getRegisterData() {
		return this.registerData;
	}

	public void setRegisterData( RegisterData registerData ) {
		this.registerData = registerData;
	}
}
