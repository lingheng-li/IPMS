package com.chinasofti.dao;

import com.chinasofti.entity.TUser;

public interface LoginDao extends BaseDao<TUser>{
	TUser findUser(String name,String pwd);
	TUser findByUsername(String userId);
}
