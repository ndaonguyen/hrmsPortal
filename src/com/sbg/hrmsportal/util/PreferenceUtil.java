package com.sbg.hrmsportal.util;

import com.sbg.hrmsportal.activities.ApplicationConstants;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil {
	private Context context;
	private SharedPreferences sharedPreferences;
	private static PreferenceUtil preferenceUtil;

	public static PreferenceUtil getInstance(Context context) {
		if (preferenceUtil == null) {
			preferenceUtil = new PreferenceUtil(context);
		}
		return preferenceUtil;
	}

	private PreferenceUtil(final Context context) {
		this.setContext(context);
		this.sharedPreferences = context.getSharedPreferences(ApplicationConstants.PREFERENCE_NAME, Context.MODE_PRIVATE);
	}

	private SharedPreferences.Editor getEditor() {
		return sharedPreferences.edit();
	}


	public String getAppUserName() {
		return sharedPreferences.getString(ApplicationConstants.PREFERENCE_APP_USERNAME, "");
	}

	public void setAppUserName(String username) {
		SharedPreferences.Editor editor = getEditor();
		editor.putString(ApplicationConstants.PREFERENCE_APP_USERNAME, username);
		editor.commit();
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
}
