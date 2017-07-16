package com.bdsoft.test.pojo;

/**
 * SysRoleRight entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SysRoleRight implements java.io.Serializable {

	// Fields

	private Long rfId;
	private SysRole sysRole;
	private SysRight sysRight;

	// Constructors

	/** default constructor */
	public SysRoleRight() {
	}

	/** full constructor */
	public SysRoleRight(SysRole sysRole, SysRight sysRight) {
		this.sysRole = sysRole;
		this.sysRight = sysRight;
	}

	// Property accessors

	public Long getRfId() {
		return this.rfId;
	}

	public void setRfId(Long rfId) {
		this.rfId = rfId;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public SysRight getSysRight() {
		return this.sysRight;
	}

	public void setSysRight(SysRight sysRight) {
		this.sysRight = sysRight;
	}

}