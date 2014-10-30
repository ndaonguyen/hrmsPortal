package com.sbg.hrmsportal.activities;

import java.util.ArrayList;
import java.util.List;

import com.sbg.hrmsportal.R;
import com.sbg.hrmsportal.classMobile.DocParse;
import com.sbg.hrmsportal.controller.ClaimController;
import com.sbg.hrmsportal.helper.Session;
import com.sbg.hrmsportal.util.BroadcastUtil;
import com.sbg.hrmsportal.view.MessageToastView;
import com.sbg.hrmsportal.view.TextViewQS;
import com.sbg.hrmsportal.view.TextViewStyled;
import com.sbg.hrmsportal.view.MessageToastView.MESSAGE_TOAST_TYPE;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ClaimDocActivity extends BaseClaimActivity {
	private ImageButton btnRefresh;
	private ImageButton btnAdd;
	
	private List<DocParse> mDocList = null;
	private ListView lvMain;
	private DocAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_claim_doc);
		
		if (ApplicationConstants.haveInternet(ClaimDocActivity.this)) {
			GetDocData getDocData = new GetDocData();
			getDocData.execute();
		} else {
			BroadcastUtil.broadcastToastMessage(ClaimDocActivity.this, R.string.msg_no_network_available_);
		}
		
	}
	
	public class GetDocData extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {
//			Context context = ClaimDocActivity.this;
//			String empCode  = PreferenceUtil.getInstance(context).getAppUserName();
//			
//			String claimResponseString	= ActivityUtil.getClaimResponseString(ClaimDocActivity.this, empCode);
//			if(claimResponseString.equals(""))
//				return "";
//			
//			return claimResponseString;
			return "test";
		}

		@Override
		protected void onPostExecute(final String claimResponse) {
			if (claimResponse != "") {
				ClaimController claimController = new ClaimController(Session.getInstance().getControllerHelper(ClaimDocActivity.this));
				claimController.parseClaim(claimResponse);
				
				initViews();
			} else {
				MessageToastView messageToastView = new MessageToastView(ClaimDocActivity.this);
				messageToastView.show(getString(R.string.msg_no_network_available_), MESSAGE_TOAST_TYPE.MESSAGE_DANGER);
			}
		}
	}
	

	private void initViews() {
		lvMain = (ListView) findViewById(R.id.lvMain);
		initAdapter();
		
		btnRefresh	= (ImageButton) findViewById(R.id.imgBtnRefresh);
		btnRefresh.setVisibility(View.GONE);
		
		btnAdd		= (ImageButton) findViewById(R.id.imgBtnAdd);
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (ApplicationConstants.haveInternet(ClaimDocActivity.this)) {
					startActivity(new Intent(ClaimDocActivity.this, ClaimDocAddActivity.class));
				} else {
					BroadcastUtil.broadcastToastMessage(ClaimDocActivity.this, R.string.msg_no_network_available_);
				}
			}
		});
		
		setTitle("Document Detail");
	}
	
	private void initAdapter() {
		mDocList = new ArrayList<DocParse>();
		mDocList.add(new DocParse(1, "claim doc desc 1", "origName1.jpg", "currentName1.jpg"));
		mDocList.add(new DocParse(2, "claim doc desc 2", "origName2.jpg", "currentName2.jpg"));
		mDocList.add(new DocParse(3, "claim doc desc 3", "origName3.jpg", "currentName3.jpg"));
		mDocList.add(new DocParse(4, "claim doc desc 4", "origName4.jpg", "currentName4.jpg"));
		mDocList.add(new DocParse(5, "claim doc desc 5", "origName5.jpg", "currentName5.jpg"));
		mDocList.add(new DocParse(6, "claim doc desc 6", "origName6.jpg", "currentName6.jpg"));
		mDocList.add(new DocParse(7, "claim doc desc 7", "origName7.jpg", "currentName7.jpg"));
		mDocList.add(new DocParse(8, "claim doc desc 8", "origName8.jpg", "currentName8.jpg"));
		
		mAdapter = new DocAdapter();
		lvMain.setAdapter(mAdapter);

		lvMain.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
				Intent intent = new Intent(ClaimDocActivity.this, ClaimDocAddActivity.class);
				startActivity(intent);
			}
		});
	}
	
	
	public class DocAdapter extends BaseAdapter {

		public class ViewHolder {
			public TextViewQS docDesc;
			public TextViewStyled docOriName;
			public TextViewStyled docCurrName;
			public ImageView btnDelete;
			public ImageView btnDownload;
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
				holder  = new ViewHolder();
				rowView = getLayoutInflater().inflate(R.layout.listitem_doc, null);

				holder.btnDownload  = (ImageView) rowView.findViewById(R.id.btnDownload);
				holder.btnDelete  	= (ImageView) rowView.findViewById(R.id.btnDelete);
				holder.docDesc 		= (TextViewQS) rowView.findViewById(R.id.docDesc);
				holder.docOriName 	= (TextViewStyled) rowView.findViewById(R.id.docOriName);
				holder.docCurrName 	= (TextViewStyled) rowView.findViewById(R.id.docCurrName);

				rowView.setTag(holder);
			} else {
				holder = (ViewHolder) rowView.getTag();
			}
			
			DocParse doc = (DocParse) getItem(index);
			holder.docDesc.setText(doc.getDocDesc());
			holder.docOriName.setText(doc.getDocOriName());
			holder.docCurrName.setText(doc.getDocCurrName());
			
			return rowView;
		}

		@Override
		public int getCount() {
			return mDocList.size();
		}

		@Override
		public Object getItem(int position) {
			return mDocList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return mDocList.get(position).getDocId();
		}
	}


	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
}
