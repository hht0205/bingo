package utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Hex;


public class DES {

	// 密钥
	static String secretKey = "";
	// 向量
	static String iv = "";
	// 加解密统一使用的编码方式
	private static String encoding = "utf-8";

	/**
	 * CBC加密
	 * 
	 * @param data
	 *            明文字符串
	 * @return 密文字符串
	 * @throws Exception
	 */
	
	
//	public DES(String channel){
//		// 密钥
//		 secretKey =WSUtil.ChannelMap.get(channel).getSecretKey();
//		// 向量
//		iv = WSUtil.ChannelMap.get(channel).getIvvalue();
//	}

	public static  String EncodeCBC(String data) {

		Key deskey = null;
		DESedeKeySpec spec;
		try {
			spec = new DESedeKeySpec(secretKey.getBytes(encoding));

			SecretKeyFactory keyfactory = SecretKeyFactory
					.getInstance("desede");
			deskey = keyfactory.generateSecret(spec);

			Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
			IvParameterSpec ips = new IvParameterSpec(iv.getBytes(encoding));
			cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
			byte[] encryptData = cipher.doFinal(data.getBytes(encoding));
			return Base64.encode(encryptData);
		} catch (Exception e) {
			WSUtil.error(e);
			return "";
		}

	}

	/**
	 * CBC解 密
	 * 
	 * @param data
	 *            密文字符串
	 * @return 明文字符串
	 * @throws Exception
	 */

	public static  String DecodeCBC(String data) {
		Key deskey = null;
		try {
			DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes(encoding));
			SecretKeyFactory keyfactory = SecretKeyFactory
					.getInstance("desede");
			deskey = keyfactory.generateSecret(spec);
			Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
			IvParameterSpec ips = new IvParameterSpec(iv.getBytes(encoding));
			cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

			byte[] decryptData = cipher.doFinal(Base64.decode(data));

			return new String(decryptData, encoding);
		} catch (Exception e) {

			WSUtil.PrintDebug(e);
			return "";
		}
	}

	
	
	
	
	public static void main(String[] args) throws Exception {
//		DES des= new DES("10000");
		DES des = new DES();
		System.out.println("123456="+des.EncodeCBC("123456"));
//		DBConnectionManager dbhelper=new DBConnectionManager();
//		PreparedStatement ps = dbhelper.getPrepStmt("select * from caipiao_user");
//		
//		
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()){
//				String username=rs.getString("username");
//				String pwd=rs.getString("pwd");
//				conn.UpdateSQL("update caipiao_user set pwd='"+DES.EncodeCBC(pwd)+"' where username='"+username+"'");
//			
//			}
		// String
		// s="[{\"userid\":\"A0\",\"name\":\"a0\"},{\"userid\":\"A1\",\"name\":\"a1\"},{\"userid\":\"A2\",\"name\":\"a2\"}]";
		// byte[] data="中国ABCabc123".getBytes("UTF-8");
		// String data1="中国ABCabc123";
		//    	
		// WSUtil.PrintDebug("ECB加密解密");
		// byte[] str3 = des3EncodeECB(key,data );
		// byte[] str4 = ees3DecodeECB(key, str3);
		// WSUtil.PrintDebug(new BASE64Encoder().encode(str3));
		// WSUtil.PrintDebug(new String(str4, "UTF-8"));
		//
		// WSUtil.PrintDebug();
		//
		// WSUtil.PrintDebug("CBC加密解密");
		// byte[] str5 = des3EncodeCBC(key, keyiv, data);
		// byte[] str6 = des3DecodeCBC(key, keyiv, str5);
		// WSUtil.PrintDebug(new BASE64Encoder().encode(str5));
		// WSUtil.PrintDebug(new String(str6, "UTF-8"));
		//
		// 	

	//	WSUtil.PrintDebug(EncodeCBC("中国中国中国中国中国ABCabc123"));
	//	WSUtil.PrintDebug(DecodeCBC(EncodeCBC("中国中国中国中国中国ABCabc123")));
		// WSUtil.PrintDebug("ECB解密");
		// WSUtil.PrintDebug(DecodeECB(EncodeECB(data1)));
		// WSUtil.PrintDebug("ECB加密");
		// WSUtil.PrintDebug(EncodeCBC(data1));
		// WSUtil.PrintDebug("CBC解密");
		// WSUtil.PrintDebug(DecodeCBC(EncodeCBC(data1)));

	}

}
