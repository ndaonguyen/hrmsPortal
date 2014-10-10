package com.sbg.hrmsportal.util;

public class Util{
	
//	public static String getLoginResponseString(Context context, String usernameTxt, String pwdTxt)
//	{
//		LoginController tableController = Session.getInstance()
//										  .getControllerHelper(context).getLoginController();
//		String loginJsonString 			= tableController.getJsonLoginString(usernameTxt, pwdTxt);
//		
//		CNetworkClient networkClient    = new CNetworkClient(context);
//		CNetworkResponse response       = networkClient.post(ApplicationConstants.getScriptUrl(ApplicationConstants.SCRIPT_DO_LOGIN),
//										  null, loginJsonString.getBytes());
//		
//		
//		if (response == null || response.status != HttpURLConnection.HTTP_OK) 
//			return "";
//		
//		String loginResponseString      = new String(response.body);
//		CLog.write(loginResponseString);
//		
//		return loginResponseString;
//	}
//	
//	
//	
	
//	public static String encryptString($text,$key,$iv) {
//		return mcrypt_encrypt(MCRYPT_RIJNDAEL_256, $key, $text, MCRYPT_MODE_ECB, $iv);
//	}
//	
//	public static String decryptString($text,$key,$iv) {
//		return mcrypt_decrypt(MCRYPT_RIJNDAEL_256, $key, $text, MCRYPT_MODE_ECB, $iv);
//	}
	
	public static String convertLink(String link, String key, String iv) {
//		String encrypted = MCrypt.bytesToHex( mcrypt.encrypt("Text to Encrypt") );
//		return bin2hex(Util::encryptString($link,$key,$iv));
		
		
		return "";
	}
	
}
