package com.chinasofti.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.chinasofti.Service.LoginService;
import com.chinasofti.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private TUser tUser;
	private LoginService loginService;

	public TUser gettUser() {
		return tUser;
	}
	public void settUser(TUser tUser) {
		this.tUser = tUser;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


	//登录
	public void login() throws Exception{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		req.setCharacterEncoding("utf-8");
		String name= req.getParameter("name");
		String pwd= req.getParameter("pwd");
		TUser user = loginService.login(name, pwd);
		if (user!=null) {
			req.getSession().setAttribute("user", user);
		}
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().write(JSONObject.fromObject(user).toString());
	}

	public String logout(){
		HttpServletRequest req = ServletActionContext.getRequest();
		req.getSession().removeAttribute("user");
		return "login";
	}
}
