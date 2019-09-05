package com.chinasofti.Util;

import java.util.List;

public class PageBean {
	//当前页数
	private Integer currentPage;
	//总记录数
	private Integer totalCount;
	//每页显示条数
	private Integer pageSize;
	//总页数
	private Integer totalPage;
	//分页列表数据
	private List list;
	
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		super();
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		//当页面没有指定显示那一页，显示第一页
		if(this.currentPage==null){
			this.currentPage=1;
		}
		//如果每页条数没有指定，默认每页显示3条
		if(this.pageSize==null){
			this.pageSize=3;
		}
		//计算总页数
		this.totalPage=(this.totalCount+this.pageSize-1)/this.pageSize;
		
		//判断挡圈页数是否超出范围
		//不能小于
		if(this.currentPage<1){
			this.currentPage=1;
		}
		//不能大于总页数
		if(this.currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}
	}
	
	public int getStart(){
		//从哪里开始查
		return (this.currentPage-1)*this.pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
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
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

}
