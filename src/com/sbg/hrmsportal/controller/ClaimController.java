package com.sbg.hrmsportal.controller;

import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sbg.hrmsportal.helper.ControllerHelper;
import com.sbg.hrmsportal.util.PreferenceUtil;

public class ClaimController extends BaseController {

	PreferenceUtil preferenceUtil;
	
	
	public ClaimController(ControllerHelper controllerHelper) {
		super(controllerHelper);
		preferenceUtil = PreferenceUtil.getInstance(context);
	}
	
	public String getJsonEmpCode(String appUsername) {
		JsonObject data = new JsonObject();
		data.addProperty("appUsername", appUsername);
		return data.toString();
	}
	
	
	public boolean parseClaim(String claimResponseString)
	{
		JsonParser parser    = new JsonParser();
		JsonElement jsonData = (JsonElement) parser.parse(claimResponseString);
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
