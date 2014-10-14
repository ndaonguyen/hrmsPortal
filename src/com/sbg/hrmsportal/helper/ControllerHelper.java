package com.sbg.hrmsportal.helper;


import android.content.Context;

import com.sbg.hrmsportal.controller.LoginController;

public class ControllerHelper {

	private Context context;
	private LoginController loginController;

	public ControllerHelper(Context context) {
		this.context = context;
	}

	public Context getContext() {
		return context;
	}

	public LoginController getLoginController() {
		if (loginController == null)
			loginController = new LoginController(this);
		return loginController;
	}
}