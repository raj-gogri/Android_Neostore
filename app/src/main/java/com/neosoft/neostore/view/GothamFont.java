package com.neosoft.neostore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by webwerks1 on 9/3/17.
 */

public class GothamFont extends TextView {


        public GothamFont(Context context) {
            super(context);
            Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/gotham-book.ttf");
            this.setTypeface(face);
        }

        public GothamFont(Context context, AttributeSet attrs) {
            super(context, attrs);
            Typeface face= Typeface.createFromAsset(context.getAssets(), "fonts/gotham-book.ttf");
            this.setTypeface(face);
        }

        public GothamFont(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/gotham-book.ttf");
            this.setTypeface(face);
        }

        protected void onDraw (Canvas canvas) {
            super.onDraw(canvas);


        }

    }

