package com.neosoft.neostore.Handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.neosoft.neostore.Activities.Demo;
import com.neosoft.neostore.Activities.MainActivity;
import com.neosoft.neostore.R;

/**
 * Created by Nidhi on 15/3/17.
 */

public class MyHandler {

	public void onNavigateButton( View view,Activity activity){

		Intent i = new Intent( view.getContext(), Demo.class );
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		view.getContext().startActivity( i );
		transitionAnimation(activity);

	}

	public void transitionAnimation( Activity activity1){

		activity1.overridePendingTransition( R.anim.slide_in_right,R.anim.slide_out_left);

	}


}
