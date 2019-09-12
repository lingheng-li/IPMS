package com.chinasofti.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.chinasofti.dao.MonthTicketDao;
import com.chinasofti.entity.TCar;

public class MonthTicketDaoImpl extends BaseDaoImpl<TCar> implements MonthTicketDao{

	@Override
	public TCar findByCarID(String carid) {

		DetachedCriteria dc = DetachedCriteria.forClass(TCar.class);
		dc.add(Restrictions.eq("carId", carid));
		List<TCar> list= (List<TCar>) getHibernateTemplate().findByCriteria(dc);
		if (list!=null&&list.size()!=0&&list.get(0).getCarToken()!=1) {
			return list.get(0);
		}
		return null;
	}

}
