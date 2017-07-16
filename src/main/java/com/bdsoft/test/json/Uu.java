package com.bdsoft.test.json;

public class Uu {
	private String name;
	private String dp;
	private String pwd;
	private String old;
	private String sex;
	private String head;
 

	public Uu(String name, String dept, String pwd, String head, String age,
			String sex) {
		super();
		this.name = name;
		this.dp = dept;
		this.pwd = pwd;
		this.head = head;
		this.old = age;
		this.sex = sex;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDp() {
		return dp;
	}


	public void setDp(String dp) {
		this.dp = dp;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getOld() {
		return old;
	}


	public void setOld(String old) {
		this.old = old;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getHead() {
		return head;
	}


	public void setHead(String head) {
		this.head = head;
	}
 

}