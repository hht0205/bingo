package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


import net.sf.json.JSONObject;

public class DoMethod {
	
	public static ResponseEntity doSome(String data,boolean isJsonResult){
		HttpURLConnection urlConnection=null;
		BufferedOutputStream bufferedOutputStream = null;
		BufferedInputStream bufferedInputStream = null;
		URL url;
		ResponseEntity responseEntity = null;
		try {
			url = new URL("http://127.0.0.1:8080/Caipiao_ServerHB/caiPiaoServlet");   //±¾µØ
			urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			bufferedOutputStream = new BufferedOutputStream(urlConnection.getOutputStream());
			bufferedOutputStream.write(data.getBytes("UTF-8"));
			bufferedOutputStream.flush();
//			Set<Entry<String, List<String>>> set = urlConnection.getHeaderFields().entrySet();
			bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
			byte[] b = new byte[bufferedInputStream.available()];
			bufferedInputStream.read(b);
			bufferedOutputStream.close();
			bufferedInputStream.close();
			JSONObject jsonObject = JSONObject.fromObject(new String(b,"UTF-8"));
			responseEntity = new ResponseEntity();
			responseEntity.setCode(jsonObject.getJSONObject("status").get("errorCode").toString());
			responseEntity.setMsg(jsonObject.getJSONObject("status").get("errorMsg").toString());
			if (isJsonResult) {
//				responseEntity.setContent(JSONObject.fromObject(DES.DecodeCBC(jsonObject.get("bizObj").toString())));
				responseEntity.setContent(DES.DecodeCBC(jsonObject.get("bizObj").toString()));
			}else {
				responseEntity.setContent(jsonObject.get("bizObj").toString());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (bufferedOutputStream!=null) {
				try {
					bufferedOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedInputStream!=null) {
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(responseEntity);
		return responseEntity;
	}
	
	public static ResponseEntity doSome2(Document data){
		HttpURLConnection urlConnection=null;
		BufferedOutputStream bufferedOutputStream = null;
		BufferedInputStream bufferedInputStream = null;
		URL url;
		ResponseEntity responseEntity = null;
		try {
			//url = new URL("http://192.168.1.90:8084/Caipiao_Server/caiPiaoServlet");
			url = new URL("http://127.0.0.1:8080/AgentBusiness/AgentBusinessServlet");
			urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			bufferedOutputStream = new BufferedOutputStream(urlConnection.getOutputStream());
			bufferedOutputStream.write(data.asXML().getBytes("UTF-8"));
			bufferedOutputStream.flush();
//			Set<Entry<String, List<String>>> set = urlConnection.getHeaderFields().entrySet();
			bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
			byte[] b = new byte[bufferedInputStream.available()];
			bufferedInputStream.read(b);
			System.out.println(new String(b,"UTF-8"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (bufferedOutputStream!=null) {
				try {
					bufferedOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedInputStream!=null) {
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return responseEntity;
	}
	
	public static void queryUserInfo(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2003");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("287c49453f25d7065081ac8591c7c432");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element userid = element2.addElement("userid");
		userid.addText("A943590");
		Element pwd = element2.addElement("userpws");
		pwd.addText("mingzhu0826");
		System.out.println(document.asXML());
		doSome2(document);
	}
	
	public static void queryPrice(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2004");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("d69450028fbd74e1b78268aac4f94ebb");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element userid = element2.addElement("userid");
		userid.addText("A943590");
		Element pwd = element2.addElement("userpws");
		pwd.addText("mingzhu0826");
		Element b = element2.addElement("version");
		b.addText("6.0");
		Element cardid = element2.addElement("cardid");
		cardid.addText("210102");
		System.out.println(document.asXML());
		doSome2(document);
	}
	
	
	public static void maxtime(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2005");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("39322e293004e3696233b792cadac9d4");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element userid = element2.addElement("cardid");
		userid.addText("360101");
		System.out.println(document.asXML());
		doSome2(document);
	}
	
	public static void drawCard(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2006");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("0d616d0563a1647a48e93f2e2c0c7a8d");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element cardid = element2.addElement("cardid");
		cardid.addText("360101");
		Element cardnum = element2.addElement("cardnum");
		cardnum.addText("1");
		Element sporder_id = element2.addElement("sporder_id");
		sporder_id.addText("HXXC12345678");
		Element sporder_time = element2.addElement("sporder_time");
		sporder_time.addText("20140605113251");
		Element md5_str = element2.addElement("md5_str");
		md5_str.addText("F444E3F4D4ABCE420A85EBC90142C114");
		Element phone = element2.addElement("phone");
		phone.addText("18511339423");
		System.out.println(document.asXML());
		doSome2(document);
	}
	
	public static void queryAreaServer(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2007");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("cf81c99974e25e22d969d34e040e9626");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element gameid = element2.addElement("gameid");
		gameid.addText("221605");
		System.out.println(document.asXML());
		doSome2(document);
	}
	
	public static void queryMobInfo(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2008");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("494722b45f3e810da693888c53cf15ee");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element mobilenum = element2.addElement("mobilenum");
		mobilenum.addText("wwwwwwwwwww");
		System.out.println(document.asXML());
		doSome2(document);
	}	
	
	public static void telcheck(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2009");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("63ffcffb4de87a38e6ea4c1bd7082ead");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element mobilenum = element2.addElement("mobilenum");
		mobilenum.addText("18511339423");
		Element price = element2.addElement("price");
		price.addText("50");		
		System.out.println(document.asXML());
		doSome2(document);
	}
	
	
	public static void telquery(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2010");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("8f2b55b6e3aa6080e68a3d3a85611c9f");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element mobilenum = element2.addElement("mobilenum");
		mobilenum.addText("18511339423");
		Element userid = element2.addElement("userid");
		userid.addText("A943590");
		Element userpws = element2.addElement("userpws");
		userpws.addText("mingzhu0826");
		Element mctype = element2.addElement("mctype");
		mctype.addText("");	
		Element price = element2.addElement("price");
		price.addText("50");
		System.out.println(document.asXML());
		doSome2(document);
	}
	
	public static void fixtelquery(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2011");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("2640d2125af5e6100f9c65266f2bbd2a");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element mobilenum = element2.addElement("mobilenum");
		mobilenum.addText("037167095581");
		Element userid = element2.addElement("userid");
		userid.addText("A943590");
		Element userpws = element2.addElement("userpws");
		userpws.addText("mingzhu0826");
		Element teltype = element2.addElement("teltype");
		teltype.addText("");	
		Element price = element2.addElement("price");
		price.addText("50");
		System.out.println(document.asXML());
		doSome2(document);
	}
	
	public static void querybill(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2012");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("584dcf880d87fe0e9bd459558cae4c3c");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element userid = element2.addElement("userid");
		userid.addText("A943590");
		Element userpws = element2.addElement("userpws");
		userpws.addText("mingzhu0826");
		Element cardid = element2.addElement("cardid");
		cardid.addText("360101");
		Element starttime = element2.addElement("starttime");
		starttime.addText("20140604");
		Element endtime = element2.addElement("endtime");
		endtime.addText("20140606");
		Element md5_str = element2.addElement("md5_str");
		md5_str.addText("EE9AF7B9F4B79FAF99FD6E2B40CF928E");
		System.out.println(document.asXML());
		doSome2(document);
	}
	
	public static void reissue(){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("message");
		Element element = message.addElement("head");
		Element comm = element.addElement("command");
		comm.addText("2013");
		Element messengerId = element.addElement("messengerId");
		messengerId.addText("HXTEST");
		Element version = element.addElement("version");
		version.addText("1.0");
		Element digest = element.addElement("digest");
		digest.addText("a44adbe51042edf78d983ede3ec3dcc1");
		Element timestamp = element.addElement("timestamp");
		timestamp.addText("20140408172721");
		Element packageId = element.addElement("packageId");
		packageId.addText("HXTEST0000000001");
		
		Element element2 = message.addElement("body");
		Element userid = element2.addElement("userid");
		userid.addText("A943590");
		Element userpws = element2.addElement("userpws");
		userpws.addText("mingzhu0826");
		Element spbillid = element2.addElement("spbillid");
		spbillid.addText("1");
		System.out.println(document.asXML());
		doSome2(document);
	}




	public static void main(String[] args) {
		reissue();
	}
	

}
