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
	 * @param teamNum ���ӱ��
	 * @return ͬһ���ӵĳ�����Ϣ
	 */
	public List<Car> getCarByTeamNum(String teamNum){
		//��ȡ��Ӧ���ӵ�˾��
		List<Driver> drivers = driverMapper.getDriverByTeamNum(teamNum);
		//��˾����Ӧ�ĳ�������cars��
		List<Car> cars = new LinkedList<Car>();
		for(Driver d:drivers) {
			cars.add(carMapper.getCarByDriverNum(d.getDriverNum()));			
		}
		return cars;
	}
}
