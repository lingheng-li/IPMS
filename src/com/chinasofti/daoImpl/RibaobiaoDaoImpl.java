package com.chinasofti.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.chinasofti.dao.RibaobiaoDao;
import com.chinasofti.entity.TDailyincome;
import com.chinasofti.entity.TRecord;

public class RibaobiaoDaoImpl extends BaseDaoImpl<TDailyincome> implements RibaobiaoDao {

	@Override
	public TDailyincome findByTime(String time) {
		DetachedCriteria dc = DetachedCriteria.forClass(TDailyincome.class);
		dc.add(Restrictions.eq("time", time));
		List<TDailyincome> list= (List<TDailyincome>) getHibernateTemplate().findByCriteria(dc);
		if(list!=null&&list.size()!=0){
			return list.get(0);
		}
		return null;
	}

	
}	
