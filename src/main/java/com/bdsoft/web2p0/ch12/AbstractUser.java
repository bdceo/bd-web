package com.bdsoft.web2p0.ch12;

import java.io.Serializable;

public class AbstractUser implements Serializable {
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AbstractUser(String name) {
		super();
		this.name = name;
	}
	public AbstractUser() {
		super(); 
	}
	
}
