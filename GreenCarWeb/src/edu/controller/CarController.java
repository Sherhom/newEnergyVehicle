package edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/car")
public class CarController {
	@RequestMapping(value="/getCarinfo", method = RequestMethod.POST)
	@ResponseBody
	public String getCarInfo(int limit, int offset, String motorcade) {
		
		return "";
	}

}
