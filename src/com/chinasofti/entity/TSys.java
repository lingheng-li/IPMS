package com.chinasofti.entity;

/**
 * TSys entity. @author MyEclipse Persistence Tools
 */

public class TSys implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer parkingSpaces;
	private Double dayIncome;
	private Double monthticketFee;

	// Constructors

	/** default constructor */
	public TSys() {
	}

	/** full constructor */
	public TSys(Integer parkingSpaces, Double dayIncome, Double monthticketFee) {
		this.parkingSpaces = parkingSpaces;
		this.dayIncome = dayIncome;
		this.monthticketFee = monthticketFee;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getParkingSpaces() {
		return this.parkingSpaces;
	}

	public void setParkingSpaces(Integer parkingSpaces) {
		this.parkingSpaces = parkingSpaces;
	}

	public Double getDayIncome() {
		return this.dayIncome;
	}

	public void setDayIncome(Double dayIncome) {
		this.dayIncome = dayIncome;
	}

	public Double getMonthticketFee() {
		return this.monthticketFee;
	}

	public void setMonthticketFee(Double monthticketFee) {
		this.monthticketFee = monthticketFee;
	}

}