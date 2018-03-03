package edu.dao;

import java.util.List;

import edu.domain.Driver;

public interface DriverMapper {
	List<Driver> getDriverByTeamNum(String motorcadeNum);
}
