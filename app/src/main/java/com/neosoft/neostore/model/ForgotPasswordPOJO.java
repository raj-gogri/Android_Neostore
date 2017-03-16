package com.neosoft.neostore.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.renderscript.BaseObj;
import android.text.TextUtils;

import com.neosoft.neostore.BR;

/**
 * Created by webwerks1 on 15/3/17.
 */

public class ForgotPasswordPOJO extends BaseObservable{

    private String userId;

    @Bindable
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        notifyPropertyChanged(BR.userId);
    }

    public boolean isValid()
    {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return !TextUtils.isEmpty(userId) && userId.matches(emailPattern) ;
    }
}
