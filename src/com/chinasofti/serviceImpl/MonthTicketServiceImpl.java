package com.chinasofti.serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.chinasofti.Service.MonthTicketService;
import com.chinasofti.Util.PageBean;
import com.chinasofti.dao.MonthTicketDao;
import com.chinasofti.entity.TCar;


public class MonthTicketServiceImpl implements MonthTicketService{
	
	private MonthTicketDao md;

	@Override
	public PageBean getBeanPage(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		Integer totalCount = md.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		List<TCar> list = md.getPageList(dc, pb.getStart(), pb.getPageSize());
		pb.setList(list);
		return pb;
	}

	public MonthTicketDao getMd() {
		return md;
	}
	public void setMd(MonthTicketDao md) {
		this.md = md;
	}
	@Override
	public void saveOrUpdate(TCar ticket) {
		md.saveOrUpdate(ticket);
	}

	@Override
	public TCar getById(Long id) {
		return md.getByID(id);
	}
	@Override
	public TCar findByCarId(String carid) {
		return md.findByCarID(carid);
	}

}
