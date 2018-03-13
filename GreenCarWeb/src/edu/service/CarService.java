package edu.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import edu.dao.CarMapper;
import edu.dao.DriverMapper;
import edu.domain.Car;
import edu.domain.Driver;
@Service
public class CarService {
	@Resource
	CarMapper carMapper;
	@Resource
	DriverMapper driverMapper;
	/**
	 * 
	 * @param teamNum 车队编号
	 * @return 同一车队的车辆信息,和该车队的车辆总数
	 */
	public Map getCarByTeamNum(String teamNum,int limit,int offset){
		List<Driver> drivers = driverMapper.getDriverByTeamNum(teamNum,limit,offset);
		List<Car> cars = new LinkedList<Car>();
		for(Driver d:drivers) {
			Car tempCar = carMapper.getCarByDriverNum(d.getDriverNum());
			cars.add(tempCar);
		}
		Map<String,Object> retInfo = new HashedMap();
		retInfo.put("cars", cars);
		retInfo.put("driverTeamNum",driverMapper.getDriverCountByTeam(teamNum));
		return retInfo;
	}
	
	/**
	 * 
	 * @param 新的车辆对象
	 * @return	是否修改成功
	 */
	public boolean sysModifyCar(Car newCar) {
		try {
			carMapper.updateCarBrandCarrying(newCar);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
		
	}
	
	public boolean sysDelCarFromTeam(String carNum) {
		try {
			driverMapper.setMotorcadeNumByCarNum(carNum,-1+"");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean sysAddCarIntoTeam(String carNum,String carTeamNum) {
		try {
			driverMapper.setMotorcadeNumByCarNum(carNum, carTeamNum);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
