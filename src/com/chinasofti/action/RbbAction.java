package com.chinasofti.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.chinasofti.Service.RibaobiaoService;
import com.chinasofti.Util.PageBean;
import com.chinasofti.entity.TDailyincome;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RbbAction extends ActionSupport {
	private Integer currentPage;
	private Integer pageSize;
	private String  time;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private RibaobiaoService rs;
	
	public String listTicket() {
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(TDailyincome.class);
		// custName:实体类的姓名
		// 判断封装参数
		if (StringUtils.isNotBlank(time)) {
			System.out.println(time);
			dc.add(Restrictions.like("time", "%" + time + "%"));
		}
		// 调用service查询分页数据(pageBean)
		PageBean pb = rs.getBeanPage(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pb);
		return "listTicket";
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

	public RibaobiaoService getRs() {
		return rs;
	}

	public void setRs(RibaobiaoService rs) {
		this.rs = rs;
	}

	
}
