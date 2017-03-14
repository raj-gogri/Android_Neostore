package com.neosoft.neostore.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.tool.util.L;

import com.neosoft.neostore.BR;

/**
 * Created by webwerks1 on 8/3/17.
 */

public class LoginUser  extends BaseObservable {

    private  String userName;
    private  String password;




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
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
