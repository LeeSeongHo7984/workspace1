package com.varxyz.jv300.mod010;

public class User {
	private String userId;	// private로 만들어 외부의 접근을 제한
	private String passwd;	// private로 만들어 외부의 접근을 제한
	private String userName;	// private로 만들어 외부의 접근을 제한
	private String ssn;	// private로 만들어 외부의 접근을 제한
	private String phone;	// private로 만들어 외부의 접근을 제한
	
	public String getUserId() {	// Getter를 사용해 본 필드의 값을 숨긴 채 내부에서 가공된 값을 사용
		return userId;
	}
	public void setUserId(String userId) {	//  Setter를 사용해 전달받은 값을 내부에서 가공해 필드에 넣어주는 방식
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
