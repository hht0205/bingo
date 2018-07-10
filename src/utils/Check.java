package utils;

import org.json.JSONObject;

import sun.org.mozilla.javascript.internal.json.JsonParser;

public class Check {
	
	
	public static  int  userCheck(String userName,String phoneNum) {
		String sql = "";
		
		return 1;
	}
	
	public static boolean isJson(String content){

	    try {
	    	org.json.JSONObject head= new org.json.JSONObject(content);
	        return  true;
	   } catch (Exception e) {
	        return false;
	  }
	}

}
