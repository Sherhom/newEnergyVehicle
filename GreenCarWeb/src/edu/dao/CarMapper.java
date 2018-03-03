package edu.dao;

import java.util.List;

import edu.domain.Car;

public interface CarMapper {
	Car getCarByDriverNum(String driverNum);
}
