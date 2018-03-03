package edu.service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

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
	 * @return 同一车队的车辆信息
	 */
	public List<Car> getCarByTeamNum(String teamNum){
		List<Driver> drivers = driverMapper.getDriverByTeamNum(teamNum);
		List<Car> cars = new LinkedList<Car>();
		for(Driver d:drivers) {
			cars.add(carMapper.getCarByDriverNum(d.getDriverNum()));			
		}
		return cars;
	}
}
