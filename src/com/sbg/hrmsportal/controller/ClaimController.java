package com.sbg.hrmsportal.controller;

import com.google.gson.JsonObject;
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

}
