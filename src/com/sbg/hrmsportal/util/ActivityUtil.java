package com.sbg.hrmsportal.util;

import java.net.HttpURLConnection;

import android.app.Activity;
import android.content.Context;

import com.sbg.hrmsportal.activities.ApplicationConstants;
import com.sbg.hrmsportal.controller.ClaimController;
import com.sbg.hrmsportal.controller.LoginController;
import com.sbg.hrmsportal.helper.CLog;
import com.sbg.hrmsportal.helper.CNetworkClient;
import com.sbg.hrmsportal.helper.CNetworkResponse;
import com.sbg.hrmsportal.helper.Session;

public class ActivityUtil extends Activity{
	
	public static String getLoginResponseString(Context context, String usernameTxt, String pwdTxt)
	{
		LoginController tableController = Session.getInstance()
										  .getControllerHelper(context).getLoginController();
		String loginJsonString 			= tableController.getJsonLoginString(usernameTxt, pwdTxt);
		
		CNetworkClient networkClient    = new CNetworkClient(context);
		CNetworkResponse response       = networkClient.post(ApplicationConstants.getScriptUrl(ApplicationConstants.SCRIPT_DO_LOGIN),
										  null, loginJsonString.getBytes());
		
		if (response == null || response.status != HttpURLConnection.HTTP_OK) 
			return "";
		
		String loginResponseString      = new String(response.body);
		CLog.write(loginResponseString);
		
		return loginResponseString;
	}
	
	
	public static String getClaimResponseString(Context context, String appUsername)
	{
		ClaimController tableController = Session.getInstance()
										  .getControllerHelper(context).getClaimController();
		String empCodeJsonString 		= tableController.getJsonEmpCode(appUsername);
		
		CNetworkClient networkClient    = new CNetworkClient(context);
		CNetworkResponse response       = networkClient.post(ApplicationConstants.getScriptUrl(ApplicationConstants.SCRIPT_GET_CLAIM),
										  null, empCodeJsonString.getBytes());
		
		if (response == null || response.status != HttpURLConnection.HTTP_OK) 
			return "";
		
		String claimDataString      = new String(response.body);
		CLog.write(claimDataString);

//		claimDataString      = ""; //Temp
		return claimDataString;
	}
	
	
	
	
}
