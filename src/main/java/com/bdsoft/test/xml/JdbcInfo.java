package com.bdsoft.test.xml;

public class JdbcInfo {
	private String driverClassName;

	private String urls;

	private String userName;

	private String password;

	public String toString() {
		return "driverClassName=" + this.driverClassName + "\nurl=" + this.urls
				+ "\nuserName=" + this.userName + "\npassword=" + this.password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrls() {
		return urls;
	}

	public void setUrls(String url) {
		this.urls = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
