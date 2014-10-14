package com.sbg.hrmsportal.activities;

import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.util.ActivityUtil;
import com.sbg.hrmsportal.util.PreferenceUtil;
import com.sbg.hrmsportal.view.MessageToastView;
import com.sbg.hrmsportal.view.MessageToastView.MESSAGE_TOAST_TYPE;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
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
	
	public class GetClaimData extends AsyncTask<Void, Void, Boolean> {

		@Override
		protected Boolean doInBackground(Void... params) {
			Context context = MainActivity.this;
			String empCode  = PreferenceUtil.getInstance(context).getAppUserName();
			
			String claimResponseString	= ActivityUtil.getClaimResponseString(MainActivity.this, empCode);
			if(claimResponseString.equals(""))
				return false;
			
			
			
			return true;
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			if (success) {
				// delay some milisec in case logo is changed
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						initViews();
					}
				}, 500);

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
