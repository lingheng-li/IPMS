package com.chinasofti.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//增或删
	void saveOrUpdate(T t);
	void save(T t);
	void delete(T t);
	void delete(Serializable id);
	void update(T t);
	T getByID(Serializable id);
	Integer getTotalCount(DetachedCriteria dc);
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
