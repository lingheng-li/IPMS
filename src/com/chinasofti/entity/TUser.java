package com.chinasofti.entity;

import java.sql.Timestamp;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Long id;
	private Timestamp addtime;
	private String password;
	private Integer access;
	private String truename;
	private Integer usertoken;
	private String username;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(Integer access, Integer usertoken) {
		this.access = access;
		this.usertoken = usertoken;
	}

	/** full constructor */
	public TUser(Timestamp addtime, String password, Integer access,
			String truename, Integer usertoken, String username) {
		this.addtime = addtime;
		this.password = password;
		this.access = access;
		this.truename = truename;
		this.usertoken = usertoken;
		this.username = username;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAccess() {
		return this.access;
	}

	public void setAccess(Integer access) {
		this.access = access;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public Integer getUsertoken() {
		return this.usertoken;
	}

	public void setUsertoken(Integer usertoken) {
		this.usertoken = usertoken;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}