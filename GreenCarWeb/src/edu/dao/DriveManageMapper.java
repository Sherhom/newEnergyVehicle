package edu.dao;

import java.util.List;

import edu.domain.CarCollisionBean;
import edu.domain.CarOverLoadBean;
import edu.domain.CarOverSpeedBean;
import edu.domain.DriverBean;

public interface DriveManageMapper {

	List<DriverBean> getDriverInfoByNameOrNum_mapper(String keyword);

	List<DriverBean> getDriverInfoByTeamNum_mapper(String teamNum);

	List<DriverBean> getDriverInfoByBoth_mapper(String teamNum, String keyword);
	
	List<DriverBean> getAllDriverInfo_mapper();

	void mofidyDriverInfo_mapper(DriverBean db);

	void delDriverInfo_mapper(String driverNum);

	void addDriverInfo_mapper(DriverBean db);
    
	List<CarOverSpeedBean> getOverSpeedInfo_mapper(String startDate,String endDate,String keyword);
	
	List<CarOverLoadBean> getOverLoadInfo_mapper(String startDate,String endDate,String keyword);
	
	List<CarCollisionBean> getCollisionInfo_mapper(String startDate,String endDate,String keyword);
}
