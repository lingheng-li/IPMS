package com.chinasofti.entity;

/**
 * TDailyincome entity. @author MyEclipse Persistence Tools
 */

public class TDailyincome implements java.io.Serializable {

	// Fields

	private Long id;
	private String time;
	private Double income;

	// Constructors

	/** default constructor */
	public TDailyincome() {
	}

	/** minimal constructor */
	public TDailyincome(Double income) {
		this.income = income;
	}

	/** full constructor */
	public TDailyincome(String time, Double income) {
		this.time = time;
		this.income = income;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getIncome() {
		return this.income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

}