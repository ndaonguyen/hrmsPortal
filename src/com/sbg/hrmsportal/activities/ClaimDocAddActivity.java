package com.sbg.hrmsportal.activities;

import com.sbg.hrmsportal.R;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ClaimDocAddActivity extends BaseClaimActivity {
	private ImageButton btnRefresh;
	private ImageButton btnAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_claim_doc_add);
		
		initViews();
	}

	private void initViews() {
		btnRefresh	= (ImageButton) findViewById(R.id.imgBtnRefresh);
		btnRefresh.setVisibility(View.GONE);
		
		btnAdd		= (ImageButton) findViewById(R.id.imgBtnAdd);
		btnAdd.setVisibility(View.GONE);
		
		setTitle("Add Document");
	}



}
