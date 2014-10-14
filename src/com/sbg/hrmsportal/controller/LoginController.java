package com.sbg.hrmsportal.controller;


import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sbg.hrmsportal.helper.ControllerHelper;
import com.sbg.hrmsportal.util.PreferenceUtil;

public class LoginController extends BaseController {

	PreferenceUtil preferenceUtil;
	
	
	public LoginController(ControllerHelper controllerHelper) {
		super(controllerHelper);
		preferenceUtil = PreferenceUtil.getInstance(context);
	}

//	public boolean mainHandleServerData(String json)
//	{
//		JsonParser parser       = new JsonParser();
//		JsonElement jsonData    = (JsonElement) parser.parse(json);
//		JsonObject dataObj      = jsonData.getAsJsonObject();
//		JsonElement dataElement = dataObj.get("data");
//		
//		
//		
//		return true;
//	}
	
	

	/**
	 * Returns the Json String for posting to server
	 * @param appUserName	username of app
	 * @param appPassword	password of app
	 * @return String
	 */
	public String getJsonLoginString(String appUsername, String appPassword) {
		
//		String eventGuestIds    = getEventGuestIds();
//		JsonObject returnObject = new JsonObject();
//		String eventSercretNull = null;
//		JsonObject data         = new JsonObject();
//		
//		data.addProperty("appUsername", appUsername);
//		data.addProperty("appPassword", appPassword);
//		data.addProperty("eventGuestIds", eventGuestIds);
//		
//		returnObject.addProperty("eventSecret", eventSercretNull);
//		returnObject.add("data", data);
//
//		return returnObject.toString();
		
		
		JsonObject data         = new JsonObject();
		data.addProperty("appUsername", appUsername);
		data.addProperty("appPassword", appPassword);
		return data.toString();
	}
	
	
	/**
	 * Returns the result from responseString
	 */
	public boolean isLoginSuccess(String loginResponseString)
	{
		JsonParser parser    = new JsonParser();
		JsonElement jsonData = (JsonElement) parser.parse(loginResponseString);
		if (jsonData == null)
			return false;
		
		try
		{
			JsonObject resultobj = jsonData.getAsJsonObject();
			JsonElement result   = resultobj.get("status");
			String resultStr     = result.getAsString();
			if(resultStr.equalsIgnoreCase("0"))
				return true;
			return false;
		}
		catch(Exception e)
		{
			Log.e("parse Json", e.getMessage());
			return false;
		}
	}

}
