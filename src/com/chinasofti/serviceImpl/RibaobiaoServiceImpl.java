package com.chinasofti.serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.chinasofti.Service.RibaobiaoService;
import com.chinasofti.Util.PageBean;
import com.chinasofti.dao.RibaobiaoDao;
import com.chinasofti.entity.TDailyincome;

public class RibaobiaoServiceImpl implements RibaobiaoService {
	private RibaobiaoDao rd;

	public PageBean getBeanPage(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		// 1.调用Dao查询总纪录数
		Integer totalCount = rd.getTotalCount(dc);
		// 2.创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 调用Dao查询分页列表数据
		List<TDailyincome> list = rd.getPageList(dc, pb.getStart(), pb.getPageSize());
		pb.setList(list);
		return pb;
	}

	public RibaobiaoDao getRd() {
		return rd;
	}

	public void setRd(RibaobiaoDao rd) {
		this.rd = rd;
	}




}
