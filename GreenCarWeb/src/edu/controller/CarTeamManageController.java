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

import edu.domain.AddCarTeamInfoBean;
import edu.domain.CarTeamInfoBean;
import edu.model.Page;
import edu.service.CarTeamInfoService;
import edu.service.CarTeamService;

@Controller
public class CarTeamManageController {
	@Resource
	CarTeamInfoService carTeamInfoService;
	@Resource
	HttpServletRequest req;
	
	@ResponseBody
	@RequestMapping(value = "/getCarTeamInfo.action")
	public String getCarTeamInfo(HttpServletResponse response) {
		
		
		String keyword=req.getParameter("keyword");
		int offset=Integer.parseInt(req.getParameter("offset"));
		int limit=Integer.parseInt(req.getParameter("limit"));
		
		System.out.println(limit);
		System.out.println(offset);
		
		System.out.println(keyword);
		
		List<CarTeamInfoBean> temp=carTeamInfoService.getCarTeamInfo_service(keyword);
		
		List<CarTeamInfoBean> result=new ArrayList<CarTeamInfoBean>();
		
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
	@RequestMapping(value = "/addCarTeamInfo.action")
	public void addCarTeamInfo(HttpServletResponse response) {
		
		
		String motorcadeNum=req.getParameter("motorcadeNum");
		String captainNum=req.getParameter("captainNum");
		int motorcadeMount=Integer.parseInt(req.getParameter("motorcadeMount"));
		/*int offset=Integer.parseInt(req.getParameter("offset"));
		int limit=Integer.parseInt(req.getParameter("limit"));
		
		System.out.println(limit);
		System.out.println(offset);*/
		
		AddCarTeamInfoBean ctb=new AddCarTeamInfoBean(motorcadeNum,captainNum,motorcadeMount);
		
		carTeamInfoService.addCarTeamInfo_service(ctb);
	}
}