package edu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.dao.DriveManageMapper;
import edu.domain.CarOverSpeedBean;
import edu.domain.DriverBean;

@Service
public class DriveManageService {
	@Resource
	DriveManageMapper driveManageMapper;
	
	public List<DriverBean> getDriverInfoByNameOrNum(String keyword){
		List<DriverBean> temp=driveManageMapper.getDriverInfoByNameOrNum_mapper(keyword);
		return temp;
		
	}
	
	public List<DriverBean> getDriverInfoByTeamNum(String teamNum){
		List<DriverBean> temp=driveManageMapper.getDriverInfoByTeamNum_mapper(teamNum);
		return temp;
		
	}
	
	public List<DriverBean> getDriverInfoByBoth(String teamNum,String keyword){
		List<DriverBean> temp=driveManageMapper.getDriverInfoByBoth_mapper(teamNum,keyword);
		return temp;
	}
	
	public List<DriverBean> getAllDriverInfo(){
		List<DriverBean> temp=driveManageMapper.getAllDriverInfo_mapper();
		return temp;
	}

    public void mofidyDriverInfo_service(DriverBean db){
    	driveManageMapper.mofidyDriverInfo_mapper(db);
    }
    
    public void delDriverInfo_service(String driverNum){
    	driveManageMapper.delDriverInfo_mapper(driverNum);
    }
    
    public void addDriverInfo_service(DriverBean db){
    	driveManageMapper.addDriverInfo_mapper(db);
    }
    
    public List<CarOverSpeedBean> getOverSpeedInfo(String startDate,String endDate,String keyword){
    	
    }
}
