package com.chinasofti.action;

import com.chinasofti.Service.FeilvService;
import com.chinasofti.entity.TSys;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FeilvAction extends ActionSupport {
	private TSys user;
	private FeilvService fs;
	public TSys getUser() {
		return user;
	}
	public void setUser(TSys user) {
		this.user = user;
	}
	public FeilvService getFs() {
		return fs;
	}
	public void setFs(FeilvService fs) {
		this.fs = fs;
	}
	
	public String list() {
		// 封装离线查询对象
		TSys sys = 	fs.findFeilv();
		ActionContext.getContext().put("pageBean", sys);
		// 调用service查询分页数据(pageBean)
		return "list";
	}
	
	public String edit(){
		TSys sys = fs.findFeilv();
		sys.setDayIncome(user.getDayIncome());
		sys.setMonthticketFee(user.getMonthticketFee());
		sys.setParkingSpaces(user.getParkingSpaces());
		fs.savefeilv(sys);
		return "list";
	}
	public String edit1(){
		TSys sys = fs.findFeilv();
		ActionContext.getContext().put("user", sys);
		return "editlist";
		
	}
	
	
}

