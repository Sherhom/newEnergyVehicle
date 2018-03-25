package edu.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_COLOR_BURNPeer;

import edu.domain.CarCollisionBean;
import edu.domain.CarOpDataBean;
import edu.domain.CarOverLoadBean;
import edu.domain.CarOverSpeedBean;
import edu.domain.DelCollisionBean;
import edu.domain.DelOverLoadBean;
import edu.domain.DelOverSpeedBean;
import edu.domain.DriverBean;
import edu.domain.SelectWorkRecordBean;
import edu.domain.WorkRecordBean;
import edu.model.Page;
import edu.service.DriveManageService;

@Controller
public class DriveManageController {
	@Resource
	DriveManageService driveManageService;
	@Resource
	HttpServletRequest req;
	
	@ResponseBody
	@RequestMapping(value = "/getDriverInfo.action")
	public String getDriverInfo(HttpServletResponse response) {
		
		String teamNum=req.getParameter("teamNum");
		String keyword=req.getParameter("keyword");
		int offset=Integer.parseInt(req.getParameter("offset"));
		int limit=Integer.parseInt(req.getParameter("limit"));
		
		System.out.println(limit);
		System.out.println(offset);
		System.out.println(teamNum);
		System.out.println(keyword);
		
		List<DriverBean> temp=null;
		if((keyword==null||keyword.equals(""))&&teamNum.equals("all")){
			System.out.println("1");
			temp=driveManageService.getAllDriverInfo();
		}else if((keyword==null||keyword.equals(""))&&!teamNum.equals("all")){
			System.out.println("2");
			temp=driveManageService.getDriverInfoByTeamNum(teamNum);
		}else if(!keyword.equals("")&&teamNum.equals("all")){
			System.out.println("3");
			temp=driveManageService.getDriverInfoByNameOrNum(keyword);
		}else if(!keyword.equals("")&&!teamNum.equals("all")){
			System.out.println("4");
			temp=driveManageService.getDriverInfoByBoth(teamNum, keyword);
		}
		
		List<DriverBean> result=new ArrayList<DriverBean>();
		
		int max=temp.size();
		if(max>(offset+limit)){
			max=offset+limit;
		}
		
	    for(int i=offset;i<max;i++){
	    	result.add(temp.get(i));
	    }
		Page page = new Page();
		page.setRows(result);
		page.setTotal(temp.size());
		Gson gson=new Gson();
		String jsonResult = gson.toJson(page);
		System.out.println(jsonResult);
		return jsonResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/modifyDriverInfo.action")
	public String modifyDriverInfo(HttpServletResponse response) {
		// driverNum, motorcadeNum, carNum, driverName,driverSex,driverPhone,driverPosition
		String driverNum=req.getParameter("driverNum");
		String motorcadeNum=req.getParameter("motorcadeNum");
		String carNum=req.getParameter("carNum");
		String driverName=req.getParameter("driverName");
	    int driverSex=Integer.parseInt(req.getParameter("driverSex"));
	    String driverPhone=req.getParameter("driverPhone");
	    String driverPosition=req.getParameter("driverPosition");
	    
	    
		System.out.println(driverNum);
		System.out.println(motorcadeNum);
		System.out.println(carNum);
		System.out.println(driverName);
		System.out.println(driverSex);
		System.out.println(driverPhone);
		System.out.println(driverPosition);
		
		DriverBean db=new DriverBean(driverNum, motorcadeNum, carNum, driverName,driverSex,driverPhone,driverPosition);
		
		driveManageService.mofidyDriverInfo_service(db);
		
		String temp="修改成功！";
		
		return temp;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/delDriverInfo.action")
	public String delDriverInfo(HttpServletResponse response) {
		
		String driverNum=req.getParameter("driverNum");
		System.out.println(driverNum);
		driveManageService.delDriverInfo_service(driverNum);
		
		String temp="修改成功！";
		
		return temp;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addDriverInfo.action")
	public String addDriverInfo(HttpServletResponse response) {
		
		String driverNum=req.getParameter("driverNum");
		String motorcadeNum=req.getParameter("motorcadeNum");
		String carNum=req.getParameter("carNum");
		String driverName=req.getParameter("driverName");
	    int driverSex=Integer.parseInt(req.getParameter("driverSex"));
	    String driverPhone=req.getParameter("driverPhone");
	    String driverPosition=req.getParameter("driverPosition");
	    
	    
		System.out.println(driverNum);
		System.out.println(motorcadeNum);
		System.out.println(carNum);
		System.out.println(driverName);
		System.out.println(driverSex);
		System.out.println(driverPhone);
		System.out.println(driverPosition);
		
		DriverBean db=new DriverBean(driverNum, motorcadeNum, carNum, driverName,driverSex,driverPhone,driverPosition);
		
		driveManageService.addDriverInfo_service(db);
		
		String temp="修改成功！";
		
		return temp;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/driveEventManage.action")
	public String getDriveEventInfo(HttpServletResponse response) {
		
		String driveEvent=req.getParameter("driveEvent");
		String startDate=req.getParameter("startDate");
		String endDate=req.getParameter("endDate");
		String keyword=req.getParameter("keyword");
		int offset=Integer.parseInt(req.getParameter("offset"));
		int limit=Integer.parseInt(req.getParameter("limit"));
		
		/*if(startDate.equals("")){
			startDate=null;
		}*/
		if(keyword.equals("")){
			System.out.println("woc");
		}
		
		System.out.println(driveEvent);
		System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(keyword);
        
        
        if(endDate==null||endDate.equals("")){
      		   System.out.println("hello");
        	   java.util.Date date=new  java.util.Date();
        	   SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd");
        	   endDate=sdf.format(date);
        	   System.out.println(endDate);
        }
        
        List<CarOverSpeedBean> os_list=null;
        List<CarOverLoadBean> ol_list=null;
        List<CarCollisionBean> cc_list=null;
        String jsonResult=null;
        //超速事件
        if(driveEvent.equals("overSpeed")){
        	List<CarOverSpeedBean> result=new ArrayList<CarOverSpeedBean>();
        	os_list=driveManageService.getOverSpeedInfo(startDate, endDate, keyword);
        	System.out.println("****"+os_list.get(0).getTimes());
        	int max=os_list.size();
        	if(max>(offset+limit)){
    			max=offset+limit;
    		}
    		
    	    for(int i=offset;i<max;i++){
    	    	result.add(os_list.get(i));
    	    }
    		Page page = new Page();
    		page.setRows(result);
    		page.setTotal(os_list.size());
    		Gson gson=new Gson();
    		jsonResult = gson.toJson(page);
    		System.out.println(jsonResult);
    		
        	
        }else if(driveEvent.equals("overLoad")){
        	//超载事件
        	List<CarOverLoadBean> result=new ArrayList<CarOverLoadBean>();
        	ol_list=driveManageService.getOverLoadInfo(startDate, endDate, keyword);
        	
        	int max=ol_list.size();
        	if(max>(offset+limit)){
    			max=offset+limit;
    		}
    		
    	    for(int i=offset;i<max;i++){
    	    	result.add(ol_list.get(i));
    	    }
    		Page page = new Page();
    		page.setRows(result);
    		page.setTotal(ol_list.size());
    		Gson gson=new Gson();
    		jsonResult = gson.toJson(page);
    		System.out.println(jsonResult);
    		
        }else if(driveEvent.equals("collision")){
        	//碰撞事件
        	cc_list=driveManageService.getCollisionInfo(startDate, endDate, keyword);
        	List<CarCollisionBean> result=new ArrayList<CarCollisionBean>();
        	
        	int max=cc_list.size();
        	if(max>(offset+limit)){
    			max=offset+limit;
    		}
    		
    	    for(int i=offset;i<max;i++){
    	    	result.add(cc_list.get(i));
    	    }
    		Page page = new Page();
    		page.setRows(result);
    		page.setTotal(cc_list.size());
    		Gson gson=new Gson();
    		jsonResult = gson.toJson(page);
    		System.out.println(jsonResult);
    		
        }else{
         
        }
        return jsonResult;
	}
       
	@ResponseBody
	@RequestMapping(value = "/delDriveEventInfo.action")
	public void delDriveEventInfo(HttpServletResponse response) {
		//event,carNum,times,maxSpeed,actualLoad,actualValue
		String event=req.getParameter("event");
		String carNum=req.getParameter("carNum");
		String times=req.getParameter("times");
		
		//SimpleDateFormat sdf = new SimpleDateFormat("M d, yyyy K:m:s a",Locale.CHINA);
		/*try {
			String  d=sdf.parse(times).toString();
			times=d;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(times);*/
		if(event.equals("overSpeed")){
			double maxSpeed=Double.parseDouble(req.getParameter("maxSpeed"));
			DelOverSpeedBean osb=new DelOverSpeedBean(carNum,times,maxSpeed);
			driveManageService.delOverSpeedInfo(osb);
		}else if(event.equals("overLoad")){
			double actualLoad=Double.parseDouble(req.getParameter("actualLoad"));
			DelOverLoadBean olb= new DelOverLoadBean(carNum,times,actualLoad);
			driveManageService.delOverLoadInfo(olb);
			
		}else if(event.equals("collision")){
			double actualValue=Double.parseDouble(req.getParameter("actualValue"));
			DelCollisionBean cb=new DelCollisionBean(carNum, times, actualValue);
			driveManageService.delCollisionInfo(cb);
		}else{
			
		}

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/workRecord.action",produces = "text/html;charset=UTF-8")
	public String getWorkRecordInfo(HttpServletResponse response) {
		
		String startDate=req.getParameter("startDate");
		String endDate=req.getParameter("endDate");
		String keyword=req.getParameter("keyword");
		int offset=Integer.parseInt(req.getParameter("offset"));
		int limit=Integer.parseInt(req.getParameter("limit"));
		
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(keyword);
		System.out.println(limit);
		System.out.println(offset);
		
		
		if(endDate==null||endDate.equals("")){
   		   System.out.println("hello");
     	   java.util.Date date=new  java.util.Date();
     	   SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd");
     	   endDate=sdf.format(date);
     	   System.out.println(endDate);
        }
		
		SelectWorkRecordBean wrb=new SelectWorkRecordBean(startDate,endDate,keyword);
		
		List<WorkRecordBean> temp=driveManageService.getWorkRecord_service(wrb);
		
		List<WorkRecordBean> result=new ArrayList<WorkRecordBean>();
		
		int max=temp.size();
		if(max>(offset+limit)){
			max=offset+limit;
		}
		
	    for(int i=offset;i<max;i++){
	    	result.add(temp.get(i));
	    }
		Page page = new Page();
		page.setRows(result);
		page.setTotal(temp.size());
		Gson gson=new Gson();
		String jsonResult = gson.toJson(page);
		System.out.println(jsonResult);
		return jsonResult;
	}
	
	
}
