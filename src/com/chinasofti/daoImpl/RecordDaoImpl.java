package com.chinasofti.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.chinasofti.dao.RecordDao;
import com.chinasofti.entity.TRecord;

public class RecordDaoImpl extends BaseDaoImpl<TRecord> implements RecordDao{

	@Override
	public List<TRecord> findCarIn() {
		DetachedCriteria dc = DetachedCriteria.forClass(TRecord.class);
		dc.add(Restrictions.eq("isover", 0));
		List<TRecord> list= (List<TRecord>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}
