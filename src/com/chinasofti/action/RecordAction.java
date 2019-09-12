package com.chinasofti.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.apache.commons.lang3.StringUtils;

import com.chinasofti.Service.FeilvService;
import com.chinasofti.Service.MonthTicketService;
import com.chinasofti.Service.RecordService;
import com.chinasofti.Util.PageBean;
import com.chinasofti.entity.TCar;
import com.chinasofti.entity.TRecord;
import com.chinasofti.entity.TSys;
import com.chinasofti.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RecordAction extends ActionSupport{
	private RecordService recordService;
	private FeilvService fs;
	private MonthTicketService ms;
	public MonthTicketService getMs() {
		return ms;
	}
	public void setMs(MonthTicketService ms) {
		this.ms = ms;
	}
	//车辆id
	private String carid;
	//当前页
	private Integer currentPage;
	//页面大小
	private Integer pageSize;
	public String getCarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public FeilvService getFs() {
		return fs;
	}
	public void setFs(FeilvService fs) {
		this.fs = fs;
	}
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
		TUser user = (TUser) req.getSession().getAttribute("user");
		if(user!=null){
			resp.setContentType("application/json;charset=utf-8");
			List<TRecord> list =recordService.CarList();
			resp.getWriter().write(JSONArray.fromObject(list).toString());
		}else{
			resp.getWriter().write(JSONObject.fromObject(user).toString());
		}

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
		recordService.updateCar(tRecord,userId);
		TSys tSys = fs.findFeilv();
		//增加车位
		tSys.setParkingSpaces(tSys.getParkingSpaces()+1);
		fs.savefeilv(tSys);
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
		String time = sdf.format(leavetime);
		recordService.saveDayRecord(time,tRecord.getFee());
		resp.setContentType("utf-8");
		resp.getWriter().print(1);
	}
	
	//车辆进入
	public void addCar() throws IOException{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		String username=req.getParameter("userId");
		String carId=req.getParameter("carId");
		TCar car= ms.findByCarId(carId);
		int id = 1;
		if (car!=null) {
			TRecord  tRecord= new TRecord();
			tRecord.setCarId(carId);
			tRecord.setIsover(0);
			tRecord.setMonthId(car);
			Date date = new Date(System.currentTimeMillis());
			Timestamp stamp=new Timestamp(date.getTime());
			tRecord.setEntertime(stamp);
			TSys tSys = fs.findFeilv();
			recordService.saveCar(tRecord,username);
			//减少车位
			tSys.setParkingSpaces(tSys.getParkingSpaces()-1);
			fs.savefeilv(tSys);
			id=0;
		}
		resp.setContentType("utf-8");
		resp.getWriter().print(id);
	}
	public String list(){
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(TRecord.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		TUser user =  (TUser) session.getAttribute("user");

		//custName:实体类的数姓名
		//判断封装参数
		if(StringUtils.isNotBlank(carid)){
			dc.add(Restrictions.like("carId", "%"+carid+"%"));
		}
		//在session里面获取User
		
		//调用service查询分页数据(pageBean)
		PageBean pb = recordService.getBeanPage(dc,currentPage,pageSize,user);
		//2.将pageBean放入request域
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
}
