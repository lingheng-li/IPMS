package com.chinasofti.entity;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Long id;
	private String username;
	private String password;
	private String truename;
	private Integer access;
	private Integer usertoken;
	private String addtime;
	private String phone;

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
	public TUser(String username, String password, String truename,
			Integer access, Integer usertoken, String addtime, String phone) {
		this.username = username;
		this.password = password;
		this.truename = truename;
		this.access = access;
		this.usertoken = usertoken;
		this.addtime = addtime;
		this.phone = phone;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public Integer getAccess() {
		return this.access;
	}

	public void setAccess(Integer access) {
		this.access = access;
	}

	public Integer getUsertoken() {
		return this.usertoken;
	}

	public void setUsertoken(Integer usertoken) {
		this.usertoken = usertoken;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}