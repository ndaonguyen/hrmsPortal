package com.sbg.hrmsportal.controller;

import com.google.gson.JsonObject;
import com.sbg.hrmsportal.helper.ControllerHelper;
import com.sbg.hrmsportal.util.PreferenceUtil;

public class DocumentController extends BaseController {

	PreferenceUtil preferenceUtil;
	
	
	public DocumentController(ControllerHelper controllerHelper) {
		super(controllerHelper);
		preferenceUtil = PreferenceUtil.getInstance(context);
	}
	
	public String getJsonDocID(String docId) {
		JsonObject data = new JsonObject();
		data.addProperty("docID", docId);
		return data.toString();
	}
	
	

}
