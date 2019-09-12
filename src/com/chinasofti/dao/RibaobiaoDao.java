package com.chinasofti.dao;

import com.chinasofti.entity.TDailyincome;

public interface RibaobiaoDao extends BaseDao<TDailyincome> {
	TDailyincome findByTime(String time);
}
