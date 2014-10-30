package com.sbg.hrmsportal.activities;

import java.util.ArrayList;
import java.util.List;

import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.view.TextViewStyleBold;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class ClaimAddActivity extends BaseClaimActivity {
	private ImageButton btnRefresh;
	private ImageButton btnAdd;
	private LinearLayout rowLayout;
	private String TemplateTag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_claim_add);
		TemplateTag = "RowTemplate";
		
		initViews();
	}

	private void initViews() {
		btnRefresh	= (ImageButton) findViewById(R.id.imgBtnRefresh);
		btnAdd		= (ImageButton) findViewById(R.id.imgBtnAdd);
		rowLayout   = (LinearLayout) findViewById(R.id.ClaimTemplateLayout);
		
		setTitle("Create Claim");
		
		btnRefresh.setVisibility(View.GONE);
		btnAdd.setVisibility(View.GONE);
		
		addOneTxtRow("Description", 1);
		addOneTxtRow("Group", 2);
		addOneSpinnerRow("Date", 3);
		addOneSpinnerRow("Travel Plan", 4);
	}
	
	private void addOneTxtRow(String label, int id) {
		LayoutInflater inflater = getLayoutInflater();
		View rowTemplateView = (View) inflater.inflate(R.layout.row_add_claim_txt_field, null);

		TextViewStyleBold labelRow = (TextViewStyleBold) rowTemplateView.findViewById(R.id.tvLabel);
		labelRow.setText(label);


		rowTemplateView.setTag(TemplateTag);
		rowTemplateView.setId(id);

		rowLayout.addView(rowTemplateView);
	}
	
	private void addOneSpinnerRow(String label, int id) {
		LayoutInflater inflater = getLayoutInflater();
		View rowTemplateView = (View) inflater.inflate(R.layout.row_add_claim_drop_field, null);

		TextViewStyleBold labelRow = (TextViewStyleBold) rowTemplateView.findViewById(R.id.tvLabel);
		labelRow.setText(label);
		
		Spinner spinnerRow = (Spinner) rowTemplateView.findViewById(R.id.spValue);
		List<String> list = new ArrayList<String>();
        list.add("Android");
        list.add("Java");
        list.add("Spinner Data");
        list.add("Spinner Adapter");
        list.add("Spinner Example");
         
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                     (this, android.R.layout.simple_spinner_item,list);
                      
        dataAdapter.setDropDownViewResource
                     (android.R.layout.simple_spinner_dropdown_item);
                      
        spinnerRow.setAdapter(dataAdapter);
         
        // Spinner item selection Listener  
        spinnerRow.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
         
		rowTemplateView.setTag(TemplateTag);
		rowTemplateView.setId(id);

		rowLayout.addView(rowTemplateView);
	}
	
	
	public void addListenerOnSpinnerItemSelection(Spinner spinner1){
        
	}
	
	
}
