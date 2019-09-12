package com.chinasofti.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.chinasofti.Service.RecordService;
import com.chinasofti.Util.PageBean;
import com.chinasofti.dao.FeilvDao;
import com.chinasofti.dao.LoginDao;
import com.chinasofti.dao.RecordDao;
import com.chinasofti.dao.RibaobiaoDao;
import com.chinasofti.entity.TDailyincome;
import com.chinasofti.entity.TRecord;
import com.chinasofti.entity.TSys;
import com.chinasofti.entity.TUser;

public class RecordServiceImpl implements RecordService{
	private RecordDao recordDao;
	private LoginDao loginDao;
	private FeilvDao fd;
	private RibaobiaoDao rd;
	public RibaobiaoDao getRd() {
		return rd;
	}
	public void setRd(RibaobiaoDao rd) {
		this.rd = rd;
	}
	public FeilvDao getFd() {
		return fd;
	}
	public void setFd(FeilvDao fd) {
		this.fd = fd;
	}
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
		Long id=(long) 1; 
		TSys sys=fd.getByID(id);
		Date date = new Date(System.currentTimeMillis());
        Timestamp stamp=new Timestamp(date.getTime());
		record.setLeavetime(stamp);
		double money = (Math.ceil(record.getLeavetime().getTime()-record.getEntertime().getTime())/1000/3600)*sys.getDayIncome();
		String fee = String.valueOf(money);
		record.setFee(fee);
		return record;
	}
	@Override
	public void saveCar(TRecord record, String username) {
		TUser user =  loginDao.findByUsername(username);
		record.setUserId(user);
		recordDao.saveOrUpdate(record);
	}
	@Override
	public void updateCar(TRecord record, String userId) {
		Long id = Long.parseLong(userId);
		TUser user =  loginDao.getByID(id);
		record.setUserId(user);
		recordDao.saveOrUpdate(record);
	}
	@Override
	public void saveDayRecord(String time,String fee) {
		TDailyincome tDailyincome= rd.findByTime(time);
		Double money = Double.valueOf(fee);
		if (tDailyincome==null) {
			tDailyincome=new TDailyincome();
			tDailyincome.setTime(time);
			tDailyincome.setIncome(money);
		}else{
			tDailyincome.setIncome(tDailyincome.getIncome()+money);
		}
		rd.saveOrUpdate(tDailyincome);
	}
	
	@Override
	public PageBean getBeanPage(DetachedCriteria dc, Integer currentPage,
			Integer pageSize, TUser user) {
		//1.调用Dao查询总记录数
		Integer totalCount = recordDao.getTotalCount(dc);
		//2.创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3.调用Dao查询分页列表数据
		List<TRecord> list = recordDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		List<TRecord> list2 = new ArrayList<>();
		if(user.getAccess()==0){
			for (TRecord tRecord : list) {
				if (tRecord.getUserId().getId()==user.getId()) {
					list2.add(tRecord);
				}
			}
		}else{
			list2=list;
		}
		//4.列表数据放入pageBean中并返回
		if (list2!=null&&list2.size()!=0) {
			pb.setList(list2);
			return pb;
		}
		return null;
	}
}
