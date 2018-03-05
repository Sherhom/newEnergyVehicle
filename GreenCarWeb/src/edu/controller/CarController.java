package edu.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.domain.Car;
import edu.service.CarService;

@Controller
@RequestMapping(value="/car")
public class CarController {
	@Resource
	CarService carService;
	
	@RequestMapping(value="/sysgetCarinfo.do", method = RequestMethod.POST)
	@ResponseBody
	public List getCarInfo(int limit, int offset, String motorcade) {
		System.out.println("in controller");
		List<Car> cars = carService.getCarByTeamNum(motorcade);
		return cars;
	}

}
