package com.chinasofti.serviceImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.chinasofti.Service.RecordService;
import com.chinasofti.dao.LoginDao;
import com.chinasofti.dao.RecordDao;
import com.chinasofti.entity.TRecord;
import com.chinasofti.entity.TUser;

public class RecordServiceImpl implements RecordService{
	private RecordDao recordDao;
	private LoginDao loginDao;
	
	public RecordDao getRecordDao() {
		return recordDao;
	}
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	@Override
	public List<TRecord> CarList() {
		List<TRecord> list = recordDao.findCarIn();
		return list;
	}
	@Override
	public TRecord findByUserId(Long Id) {
		TRecord record = recordDao.getByID(Id);
		Date date = new Date(System.currentTimeMillis());
        Timestamp stamp=new Timestamp(date.getTime());
		record.setLeavetime(stamp);
		long money = (record.getLeavetime().getTime()-record.getEntertime().getTime())/1000/3600*3;
		String fee = String.valueOf(money);
		record.setFee(fee);
		return record;
	}
	@Override
	public void saveCar(TRecord record, String userId) {
		Long id = Long.parseLong(userId);
		TUser user =  loginDao.getByID(id);
		record.setUserId(user);
		recordDao.saveOrUpdate(record);
	}
}
