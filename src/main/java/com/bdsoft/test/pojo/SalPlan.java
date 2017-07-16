package com.bdsoft.test.pojo;

/**
 * SalPlan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SalPlan implements java.io.Serializable {

	// Fields

	private Long plaId;

	private SalChance salChance;

	private String plaDate;

	private String plaTodo;

	private String plaResult;

	// Constructors

	/** default constructor */
	public SalPlan() {
	}

	/** minimal constructor */
	public SalPlan(SalChance salChance, String plaDate, String plaTodo) {
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
	}

	/** full constructor */
	public SalPlan(SalChance salChance, String plaDate, String plaTodo,
			String plaResult) {
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
		this.plaResult = plaResult;
	}

	// Property accessors

	public Long getPlaId() {
		return this.plaId;
	}

	public void setPlaId(Long plaId) {
		this.plaId = plaId;
	}

	public SalChance getSalChance() {
		return this.salChance;
	}

	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}

	public String getPlaDate() {
		return this.plaDate;
	}

	public void setPlaDate(String plaDate) {
		this.plaDate = plaDate;
	}

	public String getPlaTodo() {
		return this.plaTodo;
	}

	public void setPlaTodo(String plaTodo) {
		this.plaTodo = plaTodo;
	}

	public String getPlaResult() {
		return this.plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

}