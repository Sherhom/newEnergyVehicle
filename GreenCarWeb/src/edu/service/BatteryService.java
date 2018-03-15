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

	public Map getBatteryTable(int limit, int offset, boolean showDetached) {
		List<Battery> batterys = null;
		int total;
		if (showDetached) {
			total = batteryMapper.getBatteryCountShowDetached();
			batterys = batteryMapper.getBatteryInfoShowDetached(limit, offset);
		} else {
			batterys = batteryMapper.getBatteryInfoNotShowDetached(limit, offset);
			total = batteryMapper.getBatteryCountNotShowDetached();
		}
		List<BatteryMatainTable> batTableList = new LinkedList<>();
		Map<String, Object> retMap = new HashMap<>();
		for (int i = 0, listSize = batterys.size(); i < listSize; i++) {
			Battery tempBattery = batterys.get(i);
			Car tempCar = null;
			if (tempBattery.getCarNum() != null) {
				tempCar = carMapper.getCarByCarNum(tempBattery.getCarNum());
			}
			batTableList.add(new BatteryMatainTable(tempCar, tempBattery));
		}

		retMap.put("batTableList", batTableList);
		retMap.put("total", total);

		return retMap;
	}

	public boolean detachBattery(String batteryNum) {
		try {
			batteryMapper.setBatteryCarNum(batteryNum, "-1");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean modifyBattery(String batteryNum, String brand, String version) {
		try {
			batteryMapper.setBatteryInfo(batteryNum, brand, version);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// -1代表删除失败 0代表有车辆关联不能删除 1代表删除成功
	public int delBattery(String batteryNum) {
		try {
			Battery tempBattery = batteryMapper.getBatteryByBatteryNum(batteryNum);
			if (!"-1".equals(tempBattery.getCarNum())) {
				return 0;
			}
			batteryMapper.delBatteryByBatteryNum(batteryNum);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// -1代表删除失败 0代表有车辆关联不能删除 1代表删除成功
	public int attachBattery(String batteryNum, String carNum) {
		try {
			Battery tempBattery = batteryMapper.getBatteryByCarNum(carNum);
			if(tempBattery != null) {
				return 0;
			}
			batteryMapper.setBatteryCarNum(batteryNum, carNum);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	//-1代表添加失败 0代表已经有该编号电池不能添加 1代表添加成功
	public int addBattery(String batteryNum,String brand,String version) {
		try {
			Battery tempBattery = batteryMapper.getBatteryByBatteryNum(batteryNum);
			if(tempBattery != null) {
				return 0;
			}
			batteryMapper.addBattery(batteryNum,brand,version,"-1");
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
