package com.sbg.hrmsportal.activities;

import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.view.TextViewStyled;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends BaseActivity {
	private Button btnClaim;
	private Button btnLeave;
	private ImageButton btnBack;
	private ImageButton btnRefresh;
	private ImageButton btnLogout;
	private TextViewStyled title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		initViews();
	}
	
	private void initViews() {
		btnClaim = (Button) findViewById(R.id.btnClaim);
		btnLeave = (Button) findViewById(R.id.btnLeave);
		
		btnBack	 	= (ImageButton) findViewById(R.id.imgBtnBack);
		btnRefresh	= (ImageButton) findViewById(R.id.imgBtnRefresh);
		btnLogout	= (ImageButton) findViewById(R.id.imgBtnLogout);
		
		title    = (TextViewStyled) findViewById(R.id.tvTitle);
		title.setText("Menu");

		// Implementations
		btnClaim.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startMainActivity(); //Claim Activity
			}
		});
		
		// Implementations
		btnLeave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
			}
		});
		
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			}
		});
		
		btnLogout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
		
		btnRefresh.setVisibility(View.GONE);
	}
	
	public void startMainActivity()
	{
		final Intent mainActivity = new Intent(MenuActivity.this, MainActivity.class);
		mainActivity.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(mainActivity);
	}
	
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.menu, menu);
//		return true;
//	}

}
