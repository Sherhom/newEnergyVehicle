package edu.controller;

import java.util.List;
import java.util.Map;

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
}
