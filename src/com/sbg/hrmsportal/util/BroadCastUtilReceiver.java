package com.sbg.hrmsportal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.sbg.hrmsportal.activities.ApplicationConstants;
 
public class BroadCastUtilReceiver extends BroadcastReceiver{
    
    @Override
	public void onReceive(Context context, Intent intent) {
		String message = intent.getStringExtra(ApplicationConstants.EXTRA_KEY_TOAST_MESSAGE);
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}
     
}