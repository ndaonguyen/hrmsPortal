package com.sbg.hrmsportal.helper;

import android.util.Log;

/**
 * Utility logger, prints log only if SHOW_LOG flag is set
 *
 */
public class CLog {
	/**
	 * Tag of log to display in log cat
	 */
	private static final String LOG_TAG = "CLogger";
	/**
	 * Whether to show the log or not
	 */
	private static final boolean SHOW_LOG = true;
	
	/**
	 * Enumeration containing the type of log to display
	 */
	public enum RLogType
	{
		DEBUG(Log.DEBUG),
		WARN(Log.WARN),
		INFO(Log.INFO),
		VERBOSE(Log.VERBOSE),
		ERROR(Log.ERROR);
		
		private final int value;
		/**
		 * Assigns the corresponding log type
		 * @param value
		 */
		private RLogType(int value)
		{
			this.value = value;
		}
	}
	
	/**
	 * Prints the log in debug mode 
	 * @param message
	 */
	public static void write(String message)
	{
		write(RLogType.INFO, message == null ? "null" : message);
	}
	
	/**
	 * Print log
	 * @param logType
	 * @param message
	 */
	public static void write(RLogType logType, String message)
	{
		if (SHOW_LOG)
		{
			Log.println(logType.value, LOG_TAG, message == null ? "null" : message);
		}
	}
}
