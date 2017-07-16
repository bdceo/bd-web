package com.bdsoft.beans;

public class Stock {
	private double yesterday;
	private double today;
	private double now;
	private String name;
	private String id;
	private String tableName;

	public Stock(double yesterday, double today, String name, String id) {
		this.yesterday = yesterday;
		this.today = today;
		this.name = name;
		this.now = today;
		this.id = id;
	}

	public String toString() {
		return this.name + ":" + this.now;
	}

	/**
	 * @return the yesterday
	 */
	public double getYesterday() {
		return yesterday;
	}

	/**
	 * @param yesterday
	 *            the yesterday to set
	 */
	public void setYesterday(double yesterday) {
		this.yesterday = yesterday;
	}

	/**
	 * @return the today
	 */
	public double getToday() {
		return today;
	}

	/**
	 * @param today
	 *            the today to set
	 */
	public void setToday(double today) {
		this.today = today;
	}

	/**
	 * @return the now
	 */
	public double getNow() {
		return now;
	}

	/**
	 * @param now
	 *            the now to set
	 */
	public void setNow(double now) {
		this.now = now;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}
