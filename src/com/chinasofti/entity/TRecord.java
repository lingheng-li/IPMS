package com.chinasofti.entity;

import java.sql.Timestamp;

/**
 * TRecord entity. @author MyEclipse Persistence Tools
 */

public class TRecord implements java.io.Serializable {

	// Fields

	private Long id;
	private String carId;
	private Timestamp entertime;
	private String fee;
	private Integer isover;
	private Timestamp leavetime;
	private String type;
	private TCar monthId;
	private TUser userId;

	// Constructors

	/** default constructor */
	public TRecord() {
	}

	/** full constructor */
	public TRecord(String carId, Timestamp entertime, String fee,
			Integer isover, Timestamp leavetime, String type, TCar monthId,
			TUser userId) {
		this.carId = carId;
		this.entertime = entertime;
		this.fee = fee;
		this.isover = isover;
		this.leavetime = leavetime;
		this.type = type;
		this.monthId = monthId;
		this.userId = userId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarId() {
		return this.carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public Timestamp getEntertime() {
		return this.entertime;
	}

	public void setEntertime(Timestamp entertime) {
		this.entertime = entertime;
	}

	public String getFee() {
		return this.fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public Integer getIsover() {
		return this.isover;
	}

	public void setIsover(Integer isover) {
		this.isover = isover;
	}

	public Timestamp getLeavetime() {
		return this.leavetime;
	}

	public void setLeavetime(Timestamp leavetime) {
		this.leavetime = leavetime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TCar getMonthId() {
		return this.monthId;
	}

	public void setMonthId(TCar monthId) {
		this.monthId = monthId;
	}

	public TUser getUserId() {
		return this.userId;
	}

	public void setUserId(TUser userId) {
		this.userId = userId;
	}

}