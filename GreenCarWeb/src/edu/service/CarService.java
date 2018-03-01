package edu.service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import edu.dao.CarMapper;
import edu.dao.DriverMapper;
import edu.domain.Car;
import edu.domain.Driver;

public class CarService {
	@Resource
	CarMapper carMapper;
	@Resource
	DriverMapper driverMapper;
	/**
	 * 
	 * @param teamNum 车队编号
	 * @return 同一车队的车辆信息
	 */
	public List<Car> getCarByTeamNum(String teamNum){
		//获取对应车队的司机
		List<Driver> drivers = driverMapper.getDriverByTeamNum(teamNum);
		//将司机对应的车辆放入cars中
		List<Car> cars = new LinkedList<Car>();
		for(Driver d:drivers) {
			cars.add(carMapper.getCarByDriverNum(d.getDriverNum()));			
		}
		return cars;
	}
}
