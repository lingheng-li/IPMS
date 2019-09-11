package com.chinasofti.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.chinasofti.Service.RecordService;
import com.chinasofti.entity.TRecord;
import com.opensymphony.xwork2.ActionSupport;

public class RecordAction extends ActionSupport{
	private RecordService recordService;
	public RecordService getRecordService() {
		return recordService;
	}
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}
	
	//停车显示
	public void CarInList() throws Exception{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		List<TRecord> list =recordService.CarList();
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().write(JSONArray.fromObject(list).toString());
	}
	
	//车辆离开
	public String CarOut(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		String userId = req.getParameter("Id");
		Long Id=(long) Integer.parseInt(userId);
		TRecord  tRecord = recordService.findByUserId(Id);
		req.setAttribute("record", tRecord);
		return "carOut";
	}
	//停车结算
	public void Pay() throws Exception{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		String userId = req.getParameter("userId");
		String carId=req.getParameter("carId");
		Long id = Long.parseLong(req.getParameter("id"));
		Timestamp leavetime=Timestamp.valueOf(req.getParameter("leavetime"));
		Timestamp entertime =  Timestamp.valueOf(req.getParameter("entertime"));
		String fee=req.getParameter("fee");
		TRecord  tRecord= new TRecord();
		tRecord.setId(id);
		tRecord.setCarId(carId);
		tRecord.setEntertime(entertime);
		tRecord.setFee(fee);
		tRecord.setLeavetime(leavetime);
		tRecord.setIsover(1);
		recordService.saveCar(tRecord,userId);
		resp.setContentType("utf-8");
		resp.getWriter().print(1);
	}
	
	//车辆进入
	public void addCar() throws IOException{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		String userId=req.getParameter("userId");
		String carId=req.getParameter("carId");
		TRecord  tRecord= new TRecord();
		tRecord.setCarId(carId);
		tRecord.setIsover(0);
		Date date = new Date(System.currentTimeMillis());
		Timestamp stamp=new Timestamp(date.getTime());
		tRecord.setEntertime(stamp);
		recordService.saveCar(tRecord,userId);
		resp.setContentType("utf-8");
		resp.getWriter().print(1);
	}
	
}
