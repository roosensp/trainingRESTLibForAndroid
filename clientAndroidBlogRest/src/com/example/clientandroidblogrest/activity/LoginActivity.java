package com.example.clientandroidblogrest.activity;

import com.example.clientandroidblogrest.BlogApplication;
import com.example.clientandroidblogrest.R;
import com.example.clientandroidblogrest.R.id;
import com.example.clientandroidblogrest.R.layout;
import com.example.clientandroidblogrest.R.menu;
import com.example.clientandroidblogrest.R.string;
import com.example.clientandroidblogrest.SignUP;
import com.example.clientandroidblogrest.model.User;
import com.example.clientandroidblogrest.resttool.ImplementRESTObject;
import com.google.gson.Gson;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity  implements ImplementRESTObject{
	/**
	 * A dummy authentication store containing known user names and passwords.
	 * TODO: remove after connecting to a real authentication system.
	 */


	/**
	 * The default email to populate the email field with.
	 */
	public static final String EXTRA_USERNAME = "com.example.android.authenticatordemo.extra.USERNAME";

	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
//	private UserLoginTask mAuthTask = null;

	// Values for email and password at the time of the login attempt.
	private String mUserName;
	private String mPassword;

	// UI references.
	private EditText mUsernameView;
	private EditText mPasswordView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		// Set up the login form.
		mUserName = getIntent().getStringExtra(EXTRA_USERNAME);
		mUsernameView = (EditText) findViewById(R.id.email);
		mUsernameView.setText(mUserName);

		mPasswordView = (EditText) findViewById(R.id.password);
		mPasswordView
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.login || id == EditorInfo.IME_NULL) {
							attemptLogin();
							return true;
						}
						return false;
					}
				});

		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						attemptLogin();
					}
				});
		
		findViewById(R.id.signup).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						signupActivity() ;
					}
				});
	}

	private void signupActivity()
	{
		Intent intent = new Intent();
	  	  intent.setClass(this, SignUP.class);
	     startActivity(intent) ;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {
//		if (mAuthTask != null) {
//			return;
//		}

		// Reset errors.
		mUsernameView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		mUserName  = mUsernameView.getText().toString();
		mPassword = mPasswordView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 4) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(mUserName)) {
			mUsernameView.setError(getString(R.string.error_field_required));
			focusView = mUsernameView;
			cancel = true;
		} 

		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// Show a progress spinner, and kick off a background task to
			// perform the user login attempt.
			mLoginStatusMessageView.setText(R.string.login_progress_signing_in);
			showProgress(true);
			TokenKeyRequest tokenKeyRequest = new TokenKeyRequest() ;
			tokenKeyRequest.setTimestampClient(12333) ;
			tokenKeyRequest.getUser().setUsername(mUserName); 
			tokenKeyRequest.getUser().setPassword(mPassword) ;
			tokenKeyRequest.sendWithReturn(this, "POST") ;
//			mAuthTask = new UserLoginTask();
//			mAuthTask.execute((Void) null);
		}
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	@Override
	public void postCreate(String response) {
		// TODO Auto-generated method stub
		 showProgress(false) ;
		if(response != null)
		{
			Log.v("test" , "Post Create "+ response) ;
			 Gson gson = new Gson() ;
			  
			 ReceiveDataToken receiveDataToken  = gson.fromJson(response, ReceiveDataToken.class) ;
			 Log.v("test" , "TokenKey"+ receiveDataToken.getTokenKey()) ;
			
			 BlogApplication appclient = (BlogApplication)this.getApplicationContext() ;
			 appclient.setTokenKey(receiveDataToken.getTokenKey()) ;
			 appclient.setUtilisateurActuel(receiveDataToken.getUser());
			 this.finish() ;
		}else
		{
			Toast.makeText(this, "ERREUR" , Toast.LENGTH_LONG) ;
		}
		
	}

	@Override
	public void postUpdate(Boolean success) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postDelete(Boolean success) {
		// TODO Auto-generated method stub
		
	}

	public class ReceiveDataToken 
	{
	
		private User user ;
		private String tokenKey ;
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getTokenKey() {
			return tokenKey;
		}
		public void setTokenKey(String tokenKey) {
			this.tokenKey = tokenKey;
		}
	}

}
