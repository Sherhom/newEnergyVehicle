package edu.dao;


import java.util.Date;
import java.util.List;

import edu.domain.Car;
import edu.domain.CarLocationBean;

public interface CarMapper {
	Car getCarByDriverNum(String driverNum);
	Car getCarByCarNum(String carNum);
	void updateCarBrandCarrying(Car newCar);
	List<CarLocationBean> getPathPointsByCarNum(String carNum,Date begin, Date end);
}
