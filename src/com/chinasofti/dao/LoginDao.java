package com.chinasofti.dao;

import com.chinasofti.entity.TUser;

public interface LoginDao {
	TUser findUser(String name,String pwd);
}
