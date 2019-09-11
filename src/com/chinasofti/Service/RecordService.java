package com.chinasofti.Service;

import java.util.List;

import com.chinasofti.entity.TRecord;

public interface RecordService {
	List<TRecord> CarList();
	TRecord findByUserId(Long userId);
	void saveCar(TRecord record, String userId);
}
