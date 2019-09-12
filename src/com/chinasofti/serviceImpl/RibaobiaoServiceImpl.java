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
		// 1.����Dao��ѯ�ܼ�¼��
		Integer totalCount = rd.getTotalCount(dc);
		// 2.����PageBean����
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// ����Dao��ѯ��ҳ�б�����
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
