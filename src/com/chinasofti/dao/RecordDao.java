package com.chinasofti.dao;

import java.util.List;

import com.chinasofti.entity.TRecord;

public interface RecordDao extends BaseDao<TRecord>{
	List<TRecord> findCarIn();
//	TRecord findById(int id);
}
