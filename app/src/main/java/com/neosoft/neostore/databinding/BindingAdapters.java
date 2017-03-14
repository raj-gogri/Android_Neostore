package com.neosoft.neostore.databinding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.graphics.Typeface;
import android.widget.EditText;
import android.widget.TextView;



/**
 * Created by webwerks1 on 9/3/17.
 */

public class BindingAdapters {


@BindingAdapter({"bind:font"})
    public static void setFont(TextView textView ,String fontName){
        Typeface typeface = Typeface.createFromAsset(textView.getContext().getAssets(), fontName);
        textView.setTypeface(typeface);

    }


    @BindingAdapter({"bind:font"})
    public static void setFont(EditText textView , String fontName){
        Typeface typeface = Typeface.createFromAsset(textView.getContext().getAssets(), fontName);
        textView.setTypeface(typeface);
    }

}
