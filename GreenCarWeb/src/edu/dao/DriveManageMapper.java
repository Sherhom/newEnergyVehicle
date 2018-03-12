package edu.dao;

import java.util.List;

import edu.domain.DriverBean;

public interface DriveManageMapper {

	List<DriverBean> getDriverInfoByNameOrNum_mapper(String keyword);

	List<DriverBean> getDriverInfoByTeamNum_mapper(String teamNum);

	List<DriverBean> getDriverInfoByBoth_mapper(String teamNum, String keyword);
	
	List<DriverBean> getAllDriverInfo_mapper();

}
