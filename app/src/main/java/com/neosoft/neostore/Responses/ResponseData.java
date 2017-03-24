package com.neosoft.neostore.Responses;

/**
 * Created by Nidhi on 14/3/17.
 */

public class ResponseData {

	private String message;
	private String user_msg;
	private int status;





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

	public int getStatus() {
		return this.status;
	}

	public void setStatus( int status ) {
		this.status = status;
	}



}
