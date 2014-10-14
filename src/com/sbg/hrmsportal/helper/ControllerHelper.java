package com.sbg.hrmsportal.helper;


import android.content.Context;

import com.sbg.hrmsportal.controller.ClaimController;
import com.sbg.hrmsportal.controller.LoginController;

public class ControllerHelper {

	private Context context;
	private LoginController loginController;
	private ClaimController claimController;

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
	
	public ClaimController getClaimController() {
		if (claimController == null)
			claimController = new ClaimController(this);
		return claimController;
	}
}