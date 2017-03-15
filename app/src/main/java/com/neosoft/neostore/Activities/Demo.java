package com.neosoft.neostore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.neosoft.neostore.R;

public class Demo extends AppCompatActivity {



	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_demo );
		Toolbar toolbar = ( Toolbar ) findViewById( R.id.toolbar );
		setSupportActionBar( toolbar );



		FloatingActionButton fab = ( FloatingActionButton ) findViewById( R.id.fab );
		fab.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick( View view ) {
				Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
						.setAction( "Action", null ).show();
			}
		} );


	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();


		Intent i = new Intent( getApplicationContext(),MainActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity( i );
		transitionAnimation();
	}

	private void transitionAnimation() {

		overridePendingTransition( R.anim.slide_in_right,R.anim.slide_out_left );
	}
}

