package com.chinasofti.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.chinasofti.dao.LoginDao;
import com.chinasofti.entity.TUser;

public class LoginDaoImpl extends BaseDaoImpl<TUser> implements LoginDao{

	@Override
	public TUser findUser(String name, String pwd) {
		DetachedCriteria dc = DetachedCriteria.forClass(TUser.class);
		dc.add(Restrictions.and(Restrictions.eq("username", name), Restrictions.eq("password", pwd)));
		List<TUser> list= (List<TUser>) getHibernateTemplate().findByCriteria(dc);
		if (list!=null&&list.size()!=0&&list.get(0).getUsertoken()!=1) {
			return list.get(0);
		}
//		TUser user= (TUser) getHibernateTemplate().findByCriteria(dc);
//		if (user!=null&&user.getUsertoken()!=1) {
//			return user;
//		}
		return null;
	}

}
