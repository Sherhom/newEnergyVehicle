package edu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.service.CarManageService;

@Controller
@RequestMapping
public class CarManageController {
	@Resource
	CarManageService carManageService;
	@Resource
	HttpServletRequest req;
	
	@RequestMapping(value = "/getOpInfo", method = RequestMethod.POST)
	public String getOpInfoByKey(String carKeyword,String carTeamKeyword) {
		if((carKeyword==null ||carKeyword.equals("")) && (carTeamKeyword==null) || carTeamKeyword.equals("")){
			//搜索所有的车辆运维信息
		}else if(!carKeyword.equals("")){
			//按车辆号搜索
		}else{
			//按车队号搜索
		}
		return "";
		
		
	}


}