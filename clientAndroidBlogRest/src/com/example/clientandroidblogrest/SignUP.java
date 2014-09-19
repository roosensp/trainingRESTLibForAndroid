package com.example.clientandroidblogrest;

import com.example.clientandroidblogrest.model.User;
import com.example.clientandroidblogrest.resttool.ImplementRESTObject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SignUP extends Activity implements ImplementRESTObject{

	private EditText et_firstame ; 
	private EditText et_lastname ;
	private EditText et_about ;
	private EditText et_username ;
	private EditText et_password ;
	private Button bt_signup ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		et_firstame = (EditText) findViewById(R.id.et_firstname) ;
		et_lastname = (EditText) findViewById(R.id.et_lastname) ;
		et_about = (EditText) findViewById(R.id.et_about) ;
		et_username = (EditText) findViewById(R.id.et_username) ;
		et_password = (EditText) findViewById(R.id.et_password) ;
		bt_signup = (Button) findViewById(R.id.bt_signup) ;
		bt_signup.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onSignupClick() ;
			}
		}) ;
		
	}

	private void onSignupClick()
	{
		User u = new User() ;
		u.setFirstName(et_firstame.getText().toString()) ;
		u.setLastName(et_lastname.getText().toString()) ;
		u.setUsername(et_username.getText().toString()) ;
		u.setPassword( et_password.getText().toString());
		u.setAbout(et_about.getText().toString()) ;
		u.create(this) ;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sign_up, menu);
		return true;
	}

	@Override
	public void postCreate(String response) {
		// TODO Auto-generated method stub
		Log.v("test" ,  " id USER  " + response ) ;
	}

	@Override
	public void postUpdate(Boolean success) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postDelete(Boolean success) {
		// TODO Auto-generated method stub
		
	}

}
