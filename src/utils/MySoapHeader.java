package utils;

public class MySoapHeader {
	/**
	 * �û���
	 * */
	private String UserName;
	/**
	 * ����
	 * */
	private String UserPsw;
	/**
	 * ״̬��
	 * */
	private String Code;
	/**
	 * ip��ַ
	 * */
	private String Ip;
	/**
	 * �û�����
	 * */
	private String Operation;
	
	/**
	 * ����ӿ�����
	 * */
	private String BusinessType;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPsw() {
		return UserPsw;
	}

	public void setUserPsw(String userPsw) {
		UserPsw = userPsw;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public String getOperation() {
		return Operation;
	}

	public void setOperation(String operation) {
		Operation = operation;
	}

	public String getBusinessType() {
		return BusinessType;
	}

	public void setBusinessType(String businessType) {
		BusinessType = businessType;
	}
	
	
	

}
