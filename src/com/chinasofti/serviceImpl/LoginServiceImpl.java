package com.chinasofti.serviceImpl;

import com.chinasofti.Service.LoginService;
import com.chinasofti.dao.LoginDao;
import com.chinasofti.entity.TUser;

public class LoginServiceImpl implements LoginService{
	private LoginDao loginDao;

	@Override
	public TUser login(String name, String pwd) {
		TUser user=loginDao.findUser(name, pwd);
		return user;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
