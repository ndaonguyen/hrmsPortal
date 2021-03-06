package com.sbg.hrmsportal.activities;

import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.util.BroadcastUtil;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends BaseClaimActivity {
	private Button btnClaim;
	private Button btnLeave;
	private ImageButton btnRefresh;
	private ImageButton btnAdd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		initViews();
	}
	
	private void initViews() {
		btnClaim = (Button) findViewById(R.id.btnClaim);
		btnLeave = (Button) findViewById(R.id.btnLeave);
		
		btnRefresh	= (ImageButton) findViewById(R.id.imgBtnRefresh);
		btnAdd		= (ImageButton) findViewById(R.id.imgBtnAdd);
		
		setTitle("Menu");
		setupButton();
	}
	
	private void setupButton() {
		// Implementations
		btnClaim.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (ApplicationConstants.haveInternet(MenuActivity.this)) 
					startMainActivity(); //Claim Activity
				else
					BroadcastUtil.broadcastToastMessage(MenuActivity.this, R.string.msg_no_network_available_);
			}
		});
		
		// Implementations
		btnLeave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (ApplicationConstants.haveInternet(MenuActivity.this)) 
					BroadcastUtil.broadcastToastMessage(MenuActivity.this, R.string.update_later);
				else
					BroadcastUtil.broadcastToastMessage(MenuActivity.this, R.string.msg_no_network_available_);
			}
		});

		btnRefresh.setVisibility(View.GONE);
		btnAdd.setVisibility(View.GONE);
	}

	public void startMainActivity()
	{
		final Intent mainActivity = new Intent(MenuActivity.this, MainActivity.class);
//		mainActivity.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(mainActivity);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
