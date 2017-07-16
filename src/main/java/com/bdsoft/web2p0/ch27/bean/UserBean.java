package com.bdsoft.web2p0.ch27.bean;

public class UserBean {
	private String userName;
	private String userPwd;
	private long userId;
	public UserBean() {
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public long getUserId() {
		return userId;
	}
}
