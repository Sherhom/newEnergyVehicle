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
import edu.model.Page;
import edu.service.CarService;

@Controller
@RequestMapping(value="/car")
public class CarController {
	@Resource
	CarService carService;
	
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
	

}
