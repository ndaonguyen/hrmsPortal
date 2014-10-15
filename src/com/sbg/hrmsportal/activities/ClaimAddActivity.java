package com.sbg.hrmsportal.activities;

import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.view.TextViewStyled;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.app.Activity;

public class ClaimAddActivity extends Activity {
	private ImageButton btnRefresh;
	private ImageButton btnAdd;
	private TextViewStyled title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_claim_add);
		
		initViews();
	}

	private void initViews() {
		btnRefresh	= (ImageButton) findViewById(R.id.imgBtnRefresh);
		btnAdd		= (ImageButton) findViewById(R.id.imgBtnAdd);
		
		title    = (TextViewStyled) findViewById(R.id.tvTitle);
		title.setText("Add Claim");
		
		btnRefresh.setVisibility(View.GONE);
		btnAdd.setVisibility(View.GONE);
		
	}

}
