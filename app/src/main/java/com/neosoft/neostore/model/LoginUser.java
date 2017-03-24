package com.neosoft.neostore.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.neosoft.neostore.BR;


/**
 * Created by webwerks1 on 8/3/17.
 */

public class LoginUser extends BaseObservable {

    private String userName;
    private String password;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //    public LoginUser(String userName, String password) {
//        this.userName = userName;
//        this.password = password;
//    }
    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged( BR.userName);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public boolean isValid() {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return !TextUtils.isEmpty(userName) && userName.matches(emailPattern);
    }

}
