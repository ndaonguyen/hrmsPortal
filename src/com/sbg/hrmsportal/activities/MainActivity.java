package com.sbg.hrmsportal.activities;

import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.controller.ClaimController;
import com.sbg.hrmsportal.helper.Session;
import com.sbg.hrmsportal.util.ActivityUtil;
import com.sbg.hrmsportal.util.PreferenceUtil;
import com.sbg.hrmsportal.view.MessageToastView;
import com.sbg.hrmsportal.view.MessageToastView.MESSAGE_TOAST_TYPE;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GetClaimData getClaimData = new GetClaimData();
		getClaimData.execute();
	}
	
	public class GetClaimData extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {
			Context context = MainActivity.this;
			String empCode  = PreferenceUtil.getInstance(context).getAppUserName();
			
			String claimResponseString	= ActivityUtil.getClaimResponseString(MainActivity.this, empCode);
			if(claimResponseString.equals(""))
				return "";
			
			return "";
		}

		@Override
		protected void onPostExecute(final String claimResponse) {
			if (claimResponse != "") {
				ClaimController claimController = new ClaimController(Session.getInstance().getControllerHelper(MainActivity.this));
				claimController.parseClaim(claimResponse);
				
				initViews();
			} else {
				MessageToastView messageToastView = new MessageToastView(MainActivity.this);
				messageToastView.show(getString(R.string.msg_no_network_available_), MESSAGE_TOAST_TYPE.MESSAGE_DANGER);
			}
		}
	}
	
	private void initViews() {
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
