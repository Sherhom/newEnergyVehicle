package edu.dao;

import java.util.List;

import edu.domain.CarCollisionBean;
import edu.domain.CarOverLoadBean;
import edu.domain.CarOverSpeedBean;
import edu.domain.DelCollisionBean;
import edu.domain.DelOverLoadBean;
import edu.domain.DelOverSpeedBean;
import edu.domain.DriverBean;
import edu.domain.SelectDriveEventBean;

public interface DriveManageMapper {

	List<DriverBean> getDriverInfoByNameOrNum_mapper(String keyword);

	List<DriverBean> getDriverInfoByTeamNum_mapper(String teamNum);

	List<DriverBean> getDriverInfoByBoth_mapper(String teamNum, String keyword);
	
	List<DriverBean> getAllDriverInfo_mapper();

	void mofidyDriverInfo_mapper(DriverBean db);

	void delDriverInfo_mapper(String driverNum);

	void addDriverInfo_mapper(DriverBean db);
    
	List<CarOverSpeedBean> getOverSpeedInfo_mapper(SelectDriveEventBean sdeb);
	
	List<CarOverLoadBean> getOverLoadInfo_mapper(SelectDriveEventBean sdeb);
	
	List<CarCollisionBean> getCollisionInfo_mapper(SelectDriveEventBean sdeb);
	
	void delOverSpeedInfo_mapper(DelOverSpeedBean osb);
	
	void delOverLoadInfo_mapper(DelOverLoadBean olb);
	
	void delCollisionInfo_mapper(DelCollisionBean cb);;
}
