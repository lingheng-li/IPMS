package com.chinasofti.Util;

import java.util.List;

public class PageBean {
	//��ǰҳ��
	private Integer currentPage;
	//�ܼ�¼��
	private Integer totalCount;
	//ÿҳ��ʾ����
	private Integer pageSize;
	//��ҳ��
	private Integer totalPage;
	//��ҳ�б�����
	private List list;
	
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		super();
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		//��ҳ��û��ָ����ʾ��һҳ����ʾ��һҳ
		if(this.currentPage==null){
			this.currentPage=1;
		}
		//���ÿҳ����û��ָ����Ĭ��ÿҳ��ʾ3��
		if(this.pageSize==null){
			this.pageSize=3;
		}
		//������ҳ��
		this.totalPage=(this.totalCount+this.pageSize-1)/this.pageSize;
		
		//�жϵ�Ȧҳ���Ƿ񳬳���Χ
		//����С��
		if(this.currentPage<1){
			this.currentPage=1;
		}
		//���ܴ�����ҳ��
		if(this.currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}
	}
	
	public int getStart(){
		//�����￪ʼ��
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
