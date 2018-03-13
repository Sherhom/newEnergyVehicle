package edu.dao;

import java.util.List;

import edu.domain.Driver;

public interface DriverMapper {
	List<Driver> getDriverByTeamNum(String motorcadeNum,int limit, int offset);
	int getTotalDriverCount();
	int getDriverCountByTeam(String motorcadeNum);
	void setMotorcadeNumByCarNum(String carNum, String newMotorcadeNum);
}
