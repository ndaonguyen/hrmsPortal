package com.sbg.hrmsportal.activities;

import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.util.ActivityUtil;
import com.sbg.hrmsportal.util.BroadcastUtil;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BaseActivity {

	private EditText etUsername;
	private EditText etPassword;
	private Button btnLogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initViews();
	}
	
	private void initViews() {
		etUsername = (EditText) findViewById(R.id.etUsername);
		etPassword = (EditText) findViewById(R.id.etPassword);
		btnLogin = (Button) findViewById(R.id.btnLogin);

		//set simple
//		etUsername.setText("1_coconut");
//		etPassword.setText("coconut");
		
		// Implementations
		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				validateLogin();
			}
		});
		hideKeyboard();
	}
	
	/**
	 * To check the login. If the user Logged successfully, automatically open
	 * main screen and if not show the alert.
	 */
	private void validateLogin() {
		String usernameTxt = etUsername.getText().toString();
		String pwdTxt 	   = etPassword.getText().toString();
		doNewLoginToServer(usernameTxt, pwdTxt);
	}

	public void doNewLoginToServer(String usernameTxt, String pwdTxt)
	{
		if (ApplicationConstants.haveInternet(LoginActivity.this)) {
			UserCheckLoginTask mAuthTask = new UserCheckLoginTask();
			mAuthTask.execute(usernameTxt, pwdTxt);
			return;
		}
		BroadcastUtil.broadcastToastMessage(LoginActivity.this, R.string.msg_no_network_available_);
	}
	
	public class UserCheckLoginTask extends AsyncTask<String, Void, Boolean> {

		@Override
		protected Boolean doInBackground(String... params) {
			String usernameTxt     		= params[0];
			String pwdTxt 	       		= params[1];
			String loginResponseString	= ActivityUtil.getLoginResponseString(LoginActivity.this, 
					  usernameTxt, pwdTxt);
		
			return true;
		}
		
		@Override
		protected void onPostExecute(final Boolean success) {
			etPassword.setText("");
			if(success) {
			}
			else {
			}
		}
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.login, menu);
//		return true;
//	}

}
