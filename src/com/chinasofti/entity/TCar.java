package com.chinasofti.entity;

/**
 * TCar entity. @author MyEclipse Persistence Tools
 */

public class TCar implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer ticketId;
	private String ownerInfo;
	private String carId;
	private String dueMonth;
	private Integer carToken;

	// Constructors

	/** default constructor */
	public TCar() {
	}

	/** minimal constructor */
	public TCar(Integer carToken) {
		this.carToken = carToken;
	}

	/** full constructor */
	public TCar(Integer ticketId, String ownerInfo, String carId,
			String dueMonth, Integer carToken) {
		this.ticketId = ticketId;
		this.ownerInfo = ownerInfo;
		this.carId = carId;
		this.dueMonth = dueMonth;
		this.carToken = carToken;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getOwnerInfo() {
		return this.ownerInfo;
	}

	public void setOwnerInfo(String ownerInfo) {
		this.ownerInfo = ownerInfo;
	}

	public String getCarId() {
		return this.carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getDueMonth() {
		return this.dueMonth;
	}

	public void setDueMonth(String dueMonth) {
		this.dueMonth = dueMonth;
	}

	public Integer getCarToken() {
		return this.carToken;
	}

	public void setCarToken(Integer carToken) {
		this.carToken = carToken;
	}

}