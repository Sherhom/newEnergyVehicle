package edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import edu.domain.CarLocationBean;
import edu.domain.CarOpDataBean;
import edu.domain.GuaInfoBean;
import edu.domain.TaskInfoBean;
import edu.model.Page;
import edu.service.CarManageService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class CarManageController {
	@Resource
	CarManageService carManageService;
	@Resource
	HttpServletRequest req;
	
	@RequestMapping(value = "/getOpInfo.action", method = RequestMethod.POST)
	@ResponseBody
	public String getOpInfoByKey(HttpServletRequest req) {
		String carKeyword=req.getParameter("carKeyword");
		String carTeamKeyword=req.getParameter("carTeamKeyword");
		int offset=Integer.parseInt(req.getParameter("offset"));
		int limit=Integer.parseInt(req.getParameter("limit"));
		System.out.println("hello");
		System.out.println(limit);
		System.out.println(offset);
		System.out.println(carKeyword);
		System.out.println(carTeamKeyword);
		List<CarOpDataBean> temp=null;
		if((carKeyword==null ||carKeyword.equals("")) && (carTeamKeyword==null || carTeamKeyword.equals(""))){
			temp=carManageService.getAllOpData();
			
			System.out.println("1");
			
		}else if(!carKeyword.equals("")){
			System.out.println("2");
			temp=carManageService.getOpDataByCarNum(carKeyword);
		}else{
			//按车队号搜索
			System.out.println("3");
			temp=carManageService.getOpDataByMotorcadeNum(carTeamKeyword);
		}
		//System.out.println(temp.get(0)); 
		List<CarOpDataBean> result=new ArrayList<CarOpDataBean>();
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
	@RequestMapping(value = "/getGuaInfo_InOp.action")
	public void getGuaInfo(HttpServletRequest req,HttpServletResponse response) {
		System.out.println("进来了！");
		String carNum=req.getParameter("carNum");
		List<GuaInfoBean> temp=carManageService.getGuaInfo_service(carNum);
		
		
		Gson gson=new Gson();
		String json=gson.toJson(temp);
		System.out.println(json);
		
		try {
			PrintWriter out=response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        	
	}
	
    
	    @ResponseBody
		@RequestMapping(value = "/getTaskInfo_InOp.action")
		public void getTaskInfo(HttpServletRequest req,HttpServletResponse response) {
			System.out.println("作业进来了！");
			String motorcadeNum=req.getParameter("motorcadeNum");
			System.out.println(motorcadeNum);
			List<TaskInfoBean> temp=carManageService.getTaskInfo_service(motorcadeNum);
			
			Gson gson=new Gson();
			String json=gson.toJson(temp);
			System.out.println(json);
			
			try {
				PrintWriter out=response.getWriter();
				out.write(json);
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        	
		}
	 
	    @ResponseBody
		@RequestMapping(value = "/getPosInfo.action")
		public void getLocationInfo(HttpServletRequest req,HttpServletResponse response) {
			
			String carNum=req.getParameter("carNum");
			List<CarLocationBean> temp=carManageService.getLocationInfo_service(carNum);
			
			Gson gson=new Gson();
			String json=gson.toJson(temp.get(0));
			System.out.println(json);
			
			try {
				PrintWriter out=response.getWriter();
				out.write(json);
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        	
		}
}