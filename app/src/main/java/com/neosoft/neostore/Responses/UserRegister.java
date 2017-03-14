package com.neosoft.neostore.Responses;

/**
 * Created by webwerks on 14/3/17.
 */

public class UserRegister  {

	String id;
	String name;
	String created;
	String modified;

	public String getModified() {
		return this.modified;
	}

	public void setModified( String modified ) {
		this.modified = modified;
	}

	public String getId() {
		return this.id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getCreated() {
		return this.created;
	}

	public void setCreated( String created ) {
		this.created = created;
	}


}
