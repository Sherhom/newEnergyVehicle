package edu.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.domain.Car;
import edu.domain.CarTeam;
import edu.model.Page;
import edu.service.CarService;
import edu.service.CarTeamService;

@Controller
@RequestMapping(value="/car")
public class SysCarTeamController {
	@Resource
	CarService carService;
	@Resource
	CarTeamService carTeamService;
	
	@RequestMapping(value="/sysgetCarinfo.action", method = RequestMethod.POST)
	@ResponseBody
	public String getCarInfo(int limit, int offset, String motorcade) {
		System.out.println("in controller");
		List<Car> cars = carService.getCarByTeamNum(motorcade);
		Page page = new Page();
		page.setRows(cars);
		page.setTotal(10);
		Gson gson=new Gson();
		String jsonResult = gson.toJson(page);
		System.out.println(jsonResult);
		return jsonResult;
	}
	
	@RequestMapping(value="/initCarTeamTree.action")
	@ResponseBody
	public String getTeamTree() {
		List carTeams = carTeamService.getCarTeamAll();
		StringBuffer result = new StringBuffer("[");
		for(CarTeam each:(List<CarTeam>) carTeams) {
			result.append("{ \"text\" : \"Team").append(each.getMotorcadeNum()).append("\" },");
		}
		result.replace(result.length() - 1, result.length(), "");
		result.append("]");
		System.out.println(result);
		return result.toString();
	}
	
	@RequestMapping(value="/modifyCarInfo.action")
	@ResponseBody
	public String result(String carryingCapacity, String carBrand ) {
		System.out.println("carryingC" + carryingCapacity);
		System.out.println("carBrand " + carBrand);
		
		return "succ";
	}

}
