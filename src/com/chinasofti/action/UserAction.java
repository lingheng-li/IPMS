package com.chinasofti.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.chinasofti.Service.LoginService;
import com.chinasofti.Service.UserService;
import com.chinasofti.Util.PageBean;
import com.chinasofti.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private LoginService loginService;
	private String username;
	private Integer currentPage;
	private Integer pageSize;
	private UserService us;
	private TUser user;
	private Long userid;
	
	//查询方法
	public String list(){
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(TUser.class);
		//custName:实体类的姓名
		//判断封装参数
		if (StringUtils.isNotBlank(username)) {
			dc.add(Restrictions.like("username", "%"+username+"%"));
		}
		//调用service查询分页数据(pageBean)
		 PageBean  pb = us.getBeanPage(dc,currentPage,pageSize);
		 ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	//添加用户方法
	public String add(){
		us.saveOrUpdate(user);
		return "tolist";
	}
	//修改用户方法
	public String edit(){
		TUser user = us.getgetByID(userid);
		ActionContext.getContext().put("user", user);
		return "editList";
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
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
