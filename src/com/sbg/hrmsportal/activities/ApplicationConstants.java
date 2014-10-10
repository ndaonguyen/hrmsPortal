package com.sbg.hrmsportal.activities;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ApplicationConstants {
	public static final String APPLICATION_TAG 	   = "HRMS";
	public static final String APPLICATION_PACKAGE = "com.sbg";
	public static final String APPLICATION_VERSION = "1.0.0";
	

	/*
	 * Web url
	 */
	public static final String SERVER_URL 		= "http://192.168.1.251:8888/TurnoutWeb/mobile/"; 
	public static final String SCRIPT_DO_UPDATE = "fetchData/doUpdate";
	public static final String SCRIPT_DO_LOGIN  = "fetchData/login";


	/*
	 * Preference
	 */
	public static final String PREFERENCE_APP_USERNAME = "appUsername";
	public static final String PREFERENCE_APP_PASSWORD = "appPassword";
	public static final String PREFERENCE_NAME = "main_preference";
	
	/*
	 * Actions
	 */
	public static final String ACTION_SHOW_TOAST = APPLICATION_PACKAGE + ".ACTION_SHOW_TOAST";

	/*
	 * Extras key
	 */
	public static final String EXTRA_KEY_TOAST_MESSAGE 		 = "feedback_message";
	public static final String EXTRA_KEY_TOAST_ICON_RESOURCE = "feedback_icon";
	
	
	/**
	 * Gets the script url
	 * 
	 * @param script
	 * @return
	 */
	public static final String getScriptUrl(String script) {
		return SERVER_URL + script;
	}
	
	public static boolean haveInternet(Context context) {
		NetworkInfo info = (NetworkInfo) ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
		if (info == null || !info.isConnected()) {
			return false;
		}
		if (info.isRoaming()) {
			return false;
		}
		return true;
	}

	public static boolean haveBothGpsEnabled(Context context) {
		LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		boolean haveGps = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

		return haveGps;
	}
}
