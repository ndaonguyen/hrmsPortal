package com.sbg.hrmsportal.activities;

import java.util.ArrayList;
import java.util.List;

import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.classMobile.ClaimParse;
import com.sbg.hrmsportal.controller.ClaimController;
import com.sbg.hrmsportal.helper.Session;
import com.sbg.hrmsportal.util.ActivityUtil;
import com.sbg.hrmsportal.util.BroadcastUtil;
import com.sbg.hrmsportal.util.PreferenceUtil;
import com.sbg.hrmsportal.view.MessageToastView;
import com.sbg.hrmsportal.view.MessageToastView.MESSAGE_TOAST_TYPE;
import com.sbg.hrmsportal.view.TextViewQS;
import com.sbg.hrmsportal.view.TextViewStyled;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends BaseClaimActivity {
	
	private List<ClaimParse> mGuestList = null;
	private ListView lvMain;
	private GuestAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);     
		
		if (ApplicationConstants.haveInternet(MainActivity.this)) {
			GetClaimData getClaimData = new GetClaimData();
			getClaimData.execute();
		} else {
			BroadcastUtil.broadcastToastMessage(MainActivity.this, R.string.msg_no_network_available_);
		}
	}
	
	public class GetClaimData extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {
			Context context = MainActivity.this;
			String empCode  = PreferenceUtil.getInstance(context).getAppUserName();
			
			String claimResponseString	= ActivityUtil.getClaimResponseString(MainActivity.this, empCode);
			if(claimResponseString.equals(""))
				return "";
			
			return claimResponseString;
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
		lvMain = (ListView) findViewById(R.id.lvMain);
		initAdapter();
		
		setTitle("Claim");
	}
	
	private void initAdapter() {
		mGuestList = new ArrayList<ClaimParse>();
		mGuestList.add(new ClaimParse(1, "claim 1", "17/10/2014", "Not submitted", true));
		mGuestList.add(new ClaimParse(2, "claim 2", "1/10/2014", "Not submitted", false));
		mGuestList.add(new ClaimParse(3, "claim 3", "11/10/2014", "Not submitted", false));
		mGuestList.add(new ClaimParse(4, "claim 4", "12/10/2014", "Not submitted", false));
		mGuestList.add(new ClaimParse(5, "claim 5", "13/10/2014", "Not submitted", true));
		mGuestList.add(new ClaimParse(6, "claim 6", "14/10/2014", "Not submitted", true));
		
		mGuestList.add(new ClaimParse(7, "claim 7", "17/10/2014", "Not submitted", true));
		mGuestList.add(new ClaimParse(8, "claim 8", "1/10/2014", "Not submitted", false));
		mGuestList.add(new ClaimParse(9, "claim 9", "11/10/2014", "Not submitted", false));
		mGuestList.add(new ClaimParse(10, "claim 10", "12/10/2014", "Not submitted", false));
		mGuestList.add(new ClaimParse(11, "claim 11", "13/10/2014", "Not submitted", true));
		mGuestList.add(new ClaimParse(12, "claim 12", "14/10/2014", "Not submitted", true));
		

		mAdapter = new GuestAdapter();
		lvMain.setAdapter(mAdapter);

		lvMain.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
				Intent intent = new Intent(MainActivity.this, ClaimAddActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.slide_in_left_to_right, R.anim.slide_out_curr_to_right);
			}
		});
	}
	
	public class GuestAdapter extends BaseAdapter {

		public class ViewHolder {
			public TextViewQS clDesc;
			public TextViewStyled clStatus;
			public TextViewStyled clDate;
			public ImageView btnItem;
			public ImageView btnDoc;
			public ImageView btnMsg;
		}

		@Override
		public void notifyDataSetChanged() {
			super.notifyDataSetChanged();
		}

		@Override
		public View getView(final int index, View convertView, ViewGroup arg2) {

			final ViewHolder holder;
			View rowView = convertView;
	
			if (rowView == null) {
				holder = new ViewHolder();
				rowView = getLayoutInflater().inflate(R.layout.listitem_claim, null);

				holder.btnItem  = (ImageView) rowView.findViewById(R.id.btnItem);
				holder.btnDoc   = (ImageView) rowView.findViewById(R.id.btnDoc);
				holder.btnMsg   = (ImageView) rowView.findViewById(R.id.btnMessage);
				holder.clDesc 	= (TextViewQS) rowView.findViewById(R.id.clDesc);
				holder.clDate 	= (TextViewStyled) rowView.findViewById(R.id.clDate);
				holder.clStatus = (TextViewStyled) rowView.findViewById(R.id.clStatus);

				rowView.setTag(holder);
			} else {
				holder = (ViewHolder) rowView.getTag();
			}
			
			ClaimParse claim = (ClaimParse) getItem(index);
			holder.clDesc.setText(claim.getClaimDesc());
			holder.clDate.setText(claim.getClaimDate());
			holder.clStatus.setText(claim.getClaimStatus());
			
			holder.btnDoc.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(MainActivity.this, ClaimDocActivity.class);
					startActivity(intent);
					overridePendingTransition(R.anim.slide_in_left_to_right, R.anim.slide_out_curr_to_right);
				}
			});
			
			
			holder.btnItem.setOnClickListener(new OnClickListener() {
							
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(MainActivity.this, ClaimItemActivity.class);
					startActivity(intent);
					overridePendingTransition(R.anim.slide_in_left_to_right, R.anim.slide_out_curr_to_right);
				}
			});
			
			
			holder.btnMsg.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(MainActivity.this, ClaimMessageActivity.class);
					startActivity(intent);
					overridePendingTransition(R.anim.slide_in_left_to_right, R.anim.slide_out_curr_to_right);
				}
			});

			return rowView;
		}

		@Override
		public int getCount() {
			return mGuestList.size();
		}

		@Override
		public Object getItem(int position) {
			return mGuestList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return mGuestList.get(position).getClaimId();
		}
	}


	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
}
