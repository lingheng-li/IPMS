package com.chinasofti.Service;

import org.hibernate.criterion.DetachedCriteria;

import com.chinasofti.Util.PageBean;

public interface RibaobiaoService {
		PageBean getBeanPage(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);
}
