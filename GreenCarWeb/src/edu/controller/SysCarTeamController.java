package edu.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		System.out.println("limit : " + limit + " offset : " + offset + " motorcade : " + motorcade);
		Map<String,Object> retInfo = carService.getCarByTeamNum(motorcade,limit,offset);
		Page page = new Page();
		page.setRows((List<Car>) retInfo.get("cars"));
		page.setTotal((Integer) retInfo.get("driverTeamNum"));
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
	public String modifyCarResult(String carNum,String carryingCapacity, String carBrand ) {
		Pattern p = Pattern.compile("\\d+");
		Matcher match=p.matcher(carNum);
		match.find();
		String convertCarNum = match.group();
		Car newCar = new Car(convertCarNum,carBrand,null,Double.valueOf(carryingCapacity),-1);
		if(carService.sysModifyCar(newCar)) {
			return "Modify Success";
		}
		return "Mofidy Failed";
	}
	
	@RequestMapping(value="/delCar.action")
	@ResponseBody
	public String delCarResult(String carNum) {
		if(carService.sysDelCarFromTeam(carNum)) {
			return "Delete Success";
		}
		return "Delete Failed";
	}
	
	@RequestMapping(value="/addCar.action")
	@ResponseBody
	public String addCarResult(String carNum,String carTeamNum) {
		System.out.println("add carNum" + carNum);
		System.out.println("add carTeamNUm" + carTeamNum);
		if(carService.sysAddCarIntoTeam(carNum, carTeamNum)) {
			return "Add Success";
		}
		return "Add Failed";
	}
	
	@RequestMapping(value="/initCarTeamDetailTree.action")
	@ResponseBody
	public String getInitTeamDetailTree() {
		List carTeams = carTeamService.getCarTeamDetail();
		Gson json = new Gson();
		String result = json.toJson(carTeams);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="/queryCarPathHistory.action")
	@ResponseBody
	public String getPathHistoryImp(String carNum) {
		List points =carService.getPathPoints(carNum);
		Gson json = new Gson();
		String result = json.toJson(points);
		System.out.println(result);
		return result;
	}
	
	
	
}
