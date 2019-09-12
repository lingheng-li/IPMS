package com.chinasofti.dao;

import com.chinasofti.entity.TCar;

public interface MonthTicketDao extends BaseDao<TCar> {

	TCar findByCarID(String carid);

}
