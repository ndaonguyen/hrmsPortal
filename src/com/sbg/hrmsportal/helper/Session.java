package com.sbg.hrmsportal.helper;
import android.content.Context;


/**
 * Super singleton class to persist data across objects Basically all the
 * activities that run in a single process will get the same instance
 * 
 * 
 */
public class Session {
	private static Session session;
	private ControllerHelper controllerHelper;
	
	private Session() {
	} // Private constructor for singleton

	/**
	 * Gets the session object
	 * @return
	 */
	public static Session getInstance() {
		if (session == null)
			session = new Session();
		return session;
	}
	
	/**
	 * Utility method to get controller helper from anywhere, this method exist
	 * even if the employee is not logged in
	 * 
	 * @param context
	 * @return
	 */
	public ControllerHelper getControllerHelper(Context context) {
		if (controllerHelper == null)
			controllerHelper = new ControllerHelper(context.getApplicationContext());
		return controllerHelper;
	}
}
