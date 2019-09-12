package com.chinasofti.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.chinasofti.Service.MonthTicketService;
import com.chinasofti.Util.PageBean;
import com.chinasofti.entity.TCar;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MonthTicketAction extends ActionSupport {

	private static final long serialVersionUID = 4041433407800284301L;
	
	private Integer currentPage;
	
	private Integer pageSize;
	
	private MonthTicketService ms;
	
	private TCar ticket;
	
	private Long id;
	
	private String  ownerInfo;
	private String ticketId;
	private String carId;
	private String dueMonth;
	private String carToken;


	//��ѯ��Ʊ��Ϣ
	public String listTicket() {
		// ��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(TCar.class);
		// custName:ʵ���������
		// �жϷ�װ����
		if (StringUtils.isNotBlank(ownerInfo)) {
			dc.add(Restrictions.like("ownerInfo", "%" + ownerInfo + "%"));
		}
		// ����service��ѯ��ҳ����(pageBean)
		PageBean pb = ms.getBeanPage(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pb);
		return "listTicket";
	}
	//�����Ʊ��Ϣ
	public String add(){
		ticket.setTicketId(Integer.parseInt(ticketId));
		ticket.setCarId(carId);
		ticket.setCarToken(Integer.parseInt(carToken));
		ticket.setDueMonth(dueMonth);
		ticket.setOwnerInfo(ownerInfo);
		ms.saveOrUpdate(ticket);
		return "tolist";
	}
	//�༭��Ʊ��Ϣ
	public String edit(){
		TCar ticket = ms.getById(id);
		ActionContext.getContext().put("ticket", ticket); 
		return "toaddlist";
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

	public String getOwnerInfo() {
		return ownerInfo;
	}

	public void setOwnerInfo(String ownerInfo) {
		this.ownerInfo = ownerInfo;
	}

	public MonthTicketService getMs() {
		return ms;
	}

	public void setMs(MonthTicketService ms) {
		this.ms = ms;
	}

	public TCar getTicket() {
		return ticket;
	}

	public void setTicket(TCar ticket) {
		this.ticket = ticket;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getDueMonth() {
		return dueMonth;
	}
	public void setDueMonth(String dueMonth) {
		this.dueMonth = dueMonth;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getCarToken() {
		return carToken;
	}
	public void setCarToken(String carToken) {
		this.carToken = carToken;
	}
	
}
