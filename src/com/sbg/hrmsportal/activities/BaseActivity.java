package com.sbg.hrmsportal.activities;


import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.util.BroadcastUtil;
import com.sbg.hrmsportal.view.TextViewStyled;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public abstract class BaseActivity extends Activity{
	private ImageButton btnBack;
	private ImageButton btnRefresh;
	private ImageButton btnLogout;
	private ImageButton btnAdd;
	private TextViewStyled title;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	public void hideKeyboard() {
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}
	
	@Override
	public void onBackPressed() {
		finishActivityWithAnimation();
	}

	public void finishActivityWithAnimation() {
		super.finish();
		overridePendingTransition(R.anim.slide_in_left_to_right, R.anim.slide_out_curr_to_right);
	}

	@Override
	protected void onStart() {
		super.onStart();

		title    = (TextViewStyled) findViewById(R.id.tvTitle);
		if (btnBack == null) {
			btnBack = (ImageButton) findViewById(R.id.imgBtnBack);
			if (btnBack != null) {
				btnBack.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						if (ApplicationConstants.haveInternet(BaseActivity.this)) 
							finishActivityWithAnimation();
						else
							BroadcastUtil.broadcastToastMessage(BaseActivity.this, R.string.msg_no_network_available_);
					}
				});
			}
		}

		if (btnRefresh == null) {
			btnRefresh = (ImageButton) findViewById(R.id.imgBtnRefresh);
			if (btnRefresh != null) {
				btnRefresh.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						if (ApplicationConstants.haveInternet(BaseActivity.this)) 
							BroadcastUtil.broadcastToastMessage(BaseActivity.this, R.string.update_later);
						else
							BroadcastUtil.broadcastToastMessage(BaseActivity.this, R.string.msg_no_network_available_);
					}
				});
			}
		}

		if (btnLogout == null) {
			btnLogout = (ImageButton) findViewById(R.id.imgBtnLogout);
			if (btnLogout != null) {
				btnLogout.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// finishActivityWithAnimation();
						logout();
					}
				});
			}
		}
		
		if (btnRefresh == null) {
			btnRefresh = (ImageButton) findViewById(R.id.imgBtnRefresh);
			btnRefresh.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (ApplicationConstants.haveInternet(BaseActivity.this)) 
						BroadcastUtil.broadcastToastMessage(BaseActivity.this, R.string.update_later);
					else
						BroadcastUtil.broadcastToastMessage(BaseActivity.this, R.string.msg_no_network_available_);
				}
			});
		}
		
		if (btnAdd == null) {
			btnAdd = (ImageButton) findViewById(R.id.imgBtnAdd);
			btnAdd.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (ApplicationConstants.haveInternet(BaseActivity.this)) 
						startActivity(new Intent(BaseActivity.this, ClaimAddActivity.class));
					else
						BroadcastUtil.broadcastToastMessage(BaseActivity.this, R.string.msg_no_network_available_);
				}
			});
		}
		
		
	}
	
	protected void logout() {
		Intent loginActivity = new Intent(BaseActivity.this, LoginActivity.class);
		startActivity(loginActivity);
	}
	
	/**
	 * @param String title
	 */
	protected void setTitle(String titleStr) {
		if (title == null) 
			title    = (TextViewStyled) findViewById(R.id.tvTitle);
		
		title.setText(titleStr);
	}
}
