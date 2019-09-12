package com.chinasofti.Service;

import org.hibernate.criterion.DetachedCriteria;

import com.chinasofti.Util.PageBean;
import com.chinasofti.entity.TUser;


public interface UserService {

	PageBean getBeanPage(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	void save(TUser user);

	void saveOrUpdate(TUser user);

	TUser getgetByID(Long userid);

}
