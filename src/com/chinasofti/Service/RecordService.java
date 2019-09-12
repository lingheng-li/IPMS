package com.chinasofti.Service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.chinasofti.Util.PageBean;
import com.chinasofti.entity.TRecord;
import com.chinasofti.entity.TUser;

public interface RecordService {
	List<TRecord> CarList();
	TRecord findByUserId(Long userId);
	void saveCar(TRecord record, String userId);
	void saveDayRecord(String time, String fee);
	PageBean getBeanPage(DetachedCriteria dc, Integer currentPage,
			Integer pageSize,TUser user);
	void updateCar(TRecord record, String userId);
}
