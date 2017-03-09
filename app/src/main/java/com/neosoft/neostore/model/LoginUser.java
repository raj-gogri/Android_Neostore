package com.neosoft.neostore.model;

/**
 * Created by webwerks1 on 8/3/17.
 */

public class LoginUser {

    private  String userName;
    private  String password;




//    public LoginUser(String userName, String password) {
//        this.userName = userName;
//        this.password = password;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
