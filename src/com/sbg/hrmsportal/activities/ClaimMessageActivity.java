package com.sbg.hrmsportal.activities;

import com.sbg.hrmsportal.R;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ClaimMessageActivity extends BaseClaimActivity {
	private ImageButton btnRefresh;
	private ImageButton btnAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_claim_message);
		initViews();
	}

	private void initViews() {
		btnRefresh	= (ImageButton) findViewById(R.id.imgBtnRefresh);
		btnAdd		= (ImageButton) findViewById(R.id.imgBtnAdd);
		
		setTitle("Message");
		
		btnRefresh.setVisibility(View.GONE);
		btnAdd.setVisibility(View.GONE);
	}

}
