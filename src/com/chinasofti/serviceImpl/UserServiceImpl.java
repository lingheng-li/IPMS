package com.chinasofti.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.chinasofti.Service.UserService;
import com.chinasofti.Util.PageBean;
import com.chinasofti.dao.UserDao;
import com.chinasofti.entity.TUser;

public class UserServiceImpl implements UserService{
	private UserDao ud;
	@Override
	public PageBean getBeanPage(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		Integer totalCount = ud.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage,totalCount,pageSize);
		List<TUser> list = ud.getPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setList(list);
		return pb;
	}
	public UserDao getUd() {
		return ud;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	@Override
	public void save(TUser user) {
		
	}
	@Override
	public void saveOrUpdate(TUser user) {
		Integer usetoken = (Integer)user.getUsertoken();
		user.setUsertoken(usetoken);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String addtime = sdf.format(date);
		System.out.println(addtime);
		user.setAddtime(addtime);
		ud.saveOrUpdate(user);
	}
	@Override
	public TUser getgetByID(Long userid) {
		return ud.getByID(userid);
		
	}
	

}
