package com.sbg.hrmsportal.util;

import com.sbg.hrmsportal.activities.ApplicationConstants;
import android.content.Context;
import android.content.Intent;

public class BroadcastUtil {
	public static void broadcastToastMessage(Context context, int iconResource, String message) {
		Intent intent = new Intent(ApplicationConstants.ACTION_SHOW_TOAST);
		intent.putExtra(ApplicationConstants.EXTRA_KEY_TOAST_MESSAGE, message);
		if (iconResource != -1) {
			intent.putExtra(ApplicationConstants.EXTRA_KEY_TOAST_ICON_RESOURCE, iconResource);
		}
		context.sendBroadcast(intent);
	}

	public static void broadcastToastMessage(Context context, int message) {
		broadcastToastMessage(context, -1, context.getString(message));
	}
	
	public static void broadcastToastMessage(Context context, int iconResource, int message) {
		broadcastToastMessage(context, iconResource, context.getString(message));
	}
	
}