package com.sbg.hrmsportal.helper;


import com.sbg.hrmsportal.controller.LoginController;

import android.content.Context;

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