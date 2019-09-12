package com.chinasofti.Service;

import org.hibernate.criterion.DetachedCriteria;

import com.chinasofti.Util.PageBean;
import com.chinasofti.entity.TCar;

public interface MonthTicketService {

	PageBean getBeanPage(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	void saveOrUpdate(TCar ticket);

	TCar getById(Long id);

	TCar findByCarId(String carid);

}
