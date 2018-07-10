package comt.it.servlet;


import java.text.ParseException;

import net.sf.json.JSONObject;
import utils.DES;
import utils.MySoapHeader;

public class ServletAbstractHandler {
	/**
	 * ��������ͷ��Ϣ
	 * �����е�½У�飬���ڷǵ�½��֤�ӿ��ṩ����
	 * @throws ParseException 
	 * */
	protected MySoapHeader GetHeaderVistor(String jsonHead,String ip) throws ParseException {
		MySoapHeader myheader = new MySoapHeader();
//		JSONObject head=JSONObject.fromObject(jsonHead);	
		org.json.JSONObject head= new org.json.JSONObject(jsonHead);
		DES des= new DES();	
		String name=head.get("name").toString();
		if(name !=null && !name.equals("")){
		   myheader.setUserName(des.DecodeCBC(name));
		}			
		myheader.setIp(ip);
		String businessType=head.get("businessType").toString();
		myheader.setBusinessType(businessType);		
			
		return myheader;
	}
}
