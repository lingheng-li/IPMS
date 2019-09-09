package com.chinasofti.daoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.chinasofti.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	private Class clazz;
	
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public BaseDaoImpl(){
		ParameterizedType ptClass = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class)ptClass.getActualTypeArguments()[0];
	}
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
	T t = this.getByID(id);
	getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T getByID(Serializable id) {
		return (T)getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		
		List<Long> list = (List<Long>)getHibernateTemplate().findByCriteria(dc);
		
		dc.setProjection(null);
		if(list!=null &&list.size()>0){
			Long count = list.get(0);
			return count.intValue();
		}else{
			return null;
		}
	}
	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start,
			Integer pageSize) {
		List<T> list = (List<T>)getHibernateTemplate().findByCriteria(dc,start,pageSize);
		return list;
	}
	@Override
	public void saveOrUpdate(T t) {
		
		getHibernateTemplate().saveOrUpdate(t);
	}


}
