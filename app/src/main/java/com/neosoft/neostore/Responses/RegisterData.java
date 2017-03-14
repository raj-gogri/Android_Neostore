package com.neosoft.neostore.Responses;

/**
 * Created by webwerks on 14/3/17.
 */

public class RegisterData {

	String id;
	String access_token;

	public String getAccess_token() {
		return this.access_token;
	}

	public void setAccess_token( String access_token ) {
		this.access_token = access_token;
	}

	public String getId() {
		return this.id;
	}

	public void setId( String id ) {
		this.id = id;
	}



}
