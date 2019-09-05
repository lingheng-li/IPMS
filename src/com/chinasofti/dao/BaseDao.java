package com.chinasofti.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//增或改（有主键的时候做修改，没有主键 到时候新增）
	void saveOrUpdate(T t);
	//增
	void save(T t);
	//删
	void delete(T t);
	//删
	void delete(Serializable id);
	//改
	void update(T t);
	//查 根据ID查
	T getByID(Serializable id);
	//查 查询总记录数
	Integer getTotalCount(DetachedCriteria dc);
	//查  分页查询列表
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
