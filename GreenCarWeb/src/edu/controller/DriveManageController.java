package edu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.domain.CarOpDataBean;
import edu.domain.DriverBean;
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
	public String getGuaInfo(HttpServletResponse response) {
		
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
	
	
	
	
}