package edu.controller;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.model.BatteryMatainTable;
import edu.model.Page;
import edu.service.BatteryService;

@Controller
@RequestMapping(value = "/battery")
public class BatteryManageController {
	@Resource
	BatteryService batteryService;
	
	
	@RequestMapping(value="/initTable.action")
	@ResponseBody
	public String showBatteryTable(int limit, int offset, boolean showDetached) {
		Map resultMap = batteryService.getBatteryTable(limit,offset,showDetached);
		Gson gson=new Gson();
		Page page = new Page();
		page.setRows((List<BatteryMatainTable>) resultMap.get("batTableList"));
		page.setTotal((Integer) resultMap.get("total")); 
		String result = gson.toJson(page);
		System.out.println("result " + result);
		return result;
	}
	@RequestMapping(value="/detach.action")
	@ResponseBody
	public String detachBatteryImp(String batteryNum) {
		if(batteryService.detachBattery(batteryNum)) {
			return "Detach Success";
		}
		return "Detach Failed";
	}
	
	@RequestMapping(value="/modifyBattery.action")
	@ResponseBody
	public String modifyBatteryImp(String batteryNum,String brand,String version) {
		System.out.println(batteryNum);
		Pattern p = Pattern.compile("\\d+");
		Matcher match=p.matcher(batteryNum);
		match.find();
		String convertBatteryNum = match.group();
		if(batteryService.modifyBattery(convertBatteryNum,brand,version)) {
			return "Modify Success";
		}
		return "Modify Failed";
	}
	
	@RequestMapping(value="/del.action")
	@ResponseBody
	public String delBatteryImp(String batteryNum) {
		int returnStatus = batteryService.delBattery(batteryNum);
		if(returnStatus == -1) {
			return "Delete Failde";
		}else if(returnStatus == 0) {
			return "Please Detach First";
		}else {
			return "Delete Success";
		}
	}
	
	@RequestMapping(value="/attach.action")
	@ResponseBody
	public String attachBatteryImp(String batteryNum, String carNum) {
		System.out.println(batteryNum);
		Pattern p = Pattern.compile("\\d+");
		Matcher match=p.matcher(batteryNum);
		match.find();
		String convertCarNum = match.group();
		int returnStatus = batteryService.attachBattery(convertCarNum,carNum);
		if(returnStatus == -1) {
			return "Attach Failde";
		}else if(returnStatus == 0) {
			return "This Car Has Been Attached";
		}else {
			return "Attach Success";
		}
	}
	
	@RequestMapping(value="/addBattery.action")
	@ResponseBody
	public String addBatteryImp(String batteryNum,String brand,String version) {
		System.out.println(batteryNum);
		Pattern p = Pattern.compile("\\d+");
		Matcher match=p.matcher(batteryNum);
		match.find();
		String convertBatteryNum = match.group();
		int returnStatus = batteryService.addBattery(convertBatteryNum,brand,version);
		if(returnStatus == -1) {
			return "Add Failde";
		}else if(returnStatus == 0) {
			return "The batteryNum has been used, please change.";
		}else {
			return "Add Success";
		}
	}

	
}
