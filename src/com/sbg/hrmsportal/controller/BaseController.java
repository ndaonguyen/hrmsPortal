package com.sbg.hrmsportal.controller;

import android.content.Context;

import com.sbg.hrmsportal.helper.ControllerHelper;


public abstract class BaseController {
	private ControllerHelper controllerHelper;
	protected Context context;

	/**
	 * Base controller's constructor must be called to assign controller When
	 * controller wants to use database helper call getDatabaseHelper
	 */
	public BaseController(ControllerHelper controllerHelper) {
		this.controllerHelper = controllerHelper;
		context = controllerHelper.getContext();
	}
	

	public ControllerHelper getControllerHelper() {
		return this.controllerHelper;
	}
}
