package com.sbg.hrmsportal.activities;

import com.sbg.hrmsportal.R;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ClaimItemActivity extends BaseClaimActivity {
	private ImageButton btnRefresh;
	private ImageButton btnAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_claim_item);
		initViews();
	}

	private void initViews() {
		btnRefresh	= (ImageButton) findViewById(R.id.imgBtnRefresh);
		btnAdd		= (ImageButton) findViewById(R.id.imgBtnAdd);
		
		setTitle("Item Detail");
		
		btnRefresh.setVisibility(View.GONE);
		btnAdd.setVisibility(View.GONE);
	}

}
