package com.chinasofti.serviceImpl;

import com.chinasofti.Service.FeilvService;
import com.chinasofti.dao.FeilvDao;
import com.chinasofti.entity.TSys;

public class FeilvServiceImpl implements FeilvService {

	private FeilvDao fd;

	public FeilvDao getFd() {
		return fd;
	}

	public void setFd(FeilvDao fd) {
		this.fd = fd;
	}

	@Override
	public void savefeilv(TSys sys) {
		fd.save(sys);
	}

	@Override
	public TSys findFeilv() {
		Long id = (long) 1;
		TSys tSys=fd.getByID(id);
		return tSys;
	}









}
