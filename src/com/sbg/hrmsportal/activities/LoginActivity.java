package com.sbg.hrmsportal.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.controller.LoginController;
import com.sbg.hrmsportal.helper.Session;
import com.sbg.hrmsportal.util.BroadcastUtil;
import com.sbg.hrmsportal.view.MessageToastView;
import com.sbg.hrmsportal.view.MessageToastView.MESSAGE_TOAST_TYPE;

public class LoginActivity extends Activity {

	private EditText etUsername;
	private EditText etPassword;
	private Button btnLogin;
	private LoginController tableController;
	private MessageToastView messageToastView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		messageToastView = new MessageToastView(LoginActivity.this);
		tableController  = Session.getInstance().getControllerHelper(getApplicationContext())
				  .getLoginController();
		initViews();
	}
	
	private void initViews() {
		etUsername = (EditText) findViewById(R.id.etUsername);
		etPassword = (EditText) findViewById(R.id.etPassword);
		btnLogin = (Button) findViewById(R.id.btnLogin);

		//set simple
		etUsername.setText("ndnguyen");
		etPassword.setText("12345");
		
		// Implementations
		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				validateLogin();
			}
		});
		hideKeyboard();
	}
	
	public void hideKeyboard() {
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
//			String usernameTxt     		= params[0];
//			String pwdTxt 	       		= params[1];
			//uncomment when connecting to real server
			
//			String loginResponseString	= ActivityUtil.getLoginResponseString(LoginActivity.this, 
//					  usernameTxt, pwdTxt);
//			
//			if(loginResponseString.equals(""))
//				return false;
//			
//			boolean resultLogin    = tableController.isLoginSuccess(loginResponseString);
//			if(resultLogin == false )
//				return false;
//			
//			PreferenceUtil.getInstance(LoginActivity.this).setAppUserName(usernameTxt);
			return true;
		}
		
		@Override
		protected void onPostExecute(final Boolean success) {
			etPassword.setText("");
			if(success) {
				startModeActivity();
			}
			else {
				messageToastView.show(getString(R.string.message_login_failed), MESSAGE_TOAST_TYPE.MESSAGE_DANGER);
			}
		}
	}
	
	public void startModeActivity()
	{
		final Intent menuActivity = new Intent(LoginActivity.this, MenuActivity.class);
//		menuActivity.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(menuActivity);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_curr_to_left);
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.login, menu);
//		return true;
//	}

}
