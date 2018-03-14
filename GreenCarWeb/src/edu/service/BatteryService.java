package edu.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.dao.BatteryMapper;
import edu.dao.CarMapper;
import edu.domain.Battery;
import edu.domain.Car;
import edu.model.BatteryMatainTable;


@Service
public class BatteryService {
	@Resource
	BatteryMapper batteryMapper;
	@Resource
	CarMapper carMapper;
	
	public Map getBatteryTable(int limit,int offset,boolean showDetached) {
		List<Battery> batterys = null;
		int total;
		if(showDetached) {
			total = batteryMapper.getBatteryCountShowDetached();
			batterys = batteryMapper.getBatteryInfoShowDetached(limit, offset);			
		}else {
			batterys = batteryMapper.getBatteryInfoNotShowDetached(limit, offset);
			total = batteryMapper.getBatteryCountNotShowDetached();
		}
		List<BatteryMatainTable> batTableList = new LinkedList<>();
		Map<String,Object> retMap = new HashMap<>();
		for(int i = 0, listSize = batterys.size(); i < listSize; i++) {
			Battery tempBattery = batterys.get(i);
			Car tempCar = null;
			if(tempBattery.getCarNum() != null) {
				tempCar = carMapper.getCarByCarNum(tempBattery.getCarNum());
			}			
			batTableList.add(new BatteryMatainTable(tempCar, tempBattery));
		}
		
		retMap.put("batTableList", batTableList);
		retMap.put("total", total);
		
		return retMap;
	}
}
