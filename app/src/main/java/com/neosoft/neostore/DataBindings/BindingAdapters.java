package com.neosoft.neostore.DataBindings;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nidhi on 10/3/17.
 */

public class BindingAdapters {



	@BindingAdapter({"bind:font"})
	public static void setFont( TextView textView , String fontName){
		Typeface typeface = Typeface.createFromAsset( textView.getContext().getAssets(), fontName);
		textView.setTypeface(typeface);

	}


	@BindingAdapter({"bind:font"})
	public static void setFont( EditText textView , String fontName){
		Typeface typeface = Typeface.createFromAsset(textView.getContext().getAssets(), fontName);
		textView.setTypeface(typeface);

	}
}