package com.chinasofti.Service;

import com.chinasofti.entity.TUser;

public interface LoginService {
	TUser login(String name,String pwd);
}
