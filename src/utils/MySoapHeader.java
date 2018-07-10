package utils;

public class MySoapHeader {
	/**
	 * 用户名
	 * */
	private String UserName;
	/**
	 * 密码
	 * */
	private String UserPsw;
	/**
	 * 状态码
	 * */
	private String Code;
	/**
	 * ip地址
	 * */
	private String Ip;
	/**
	 * 用户操作
	 * */
	private String Operation;
	
	/**
	 * 请求接口类型
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
