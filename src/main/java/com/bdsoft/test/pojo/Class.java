package com.bdsoft.test.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Class entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Class implements java.io.Serializable {

	// Fields

	private String cid;
	private String cname;
	private Set stuInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Class() {
	}

	/** full constructor */
	public Class(String cname, Set stuInfos) {
		this.cname = cname;
		this.stuInfos = stuInfos;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getStuInfos() {
		return this.stuInfos;
	}

	public void setStuInfos(Set stuInfos) {
		this.stuInfos = stuInfos;
	}

}