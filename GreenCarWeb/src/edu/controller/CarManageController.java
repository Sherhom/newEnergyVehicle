package edu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.domain.CarOpDataBean;
import edu.service.CarManageService;

@Controller
public class CarManageController {
	@Resource
	CarManageService carManageService;
	@Resource
	HttpServletRequest req;
	
	@RequestMapping(value = "/getOpInfo")
	public ModelAndView getOpInfoByKey(HttpServletRequest req) {
		String carKeyword=req.getParameter("carKeyword");
		String carTeamKeyword=req.getParameter("carTeamKeyword");
		System.out.println("hello");
		if((carKeyword==null ||carKeyword.equals("")) && (carTeamKeyword==null) || carTeamKeyword.equals("")){
			List<CarOpDataBean> temp=carManageService.getAllOpData();
			System.out.println(temp.get(0));
			ModelAndView mv = new ModelAndView();
			mv.addObject("allOpInfo",temp);
			mv.setViewName("/company/carOpInfo.jsp");
			return mv;
		}else if(!carKeyword.equals("")){
			//按车辆号搜索
		}else{
			//按车队号搜索
		}
		return null;
		
	}


}