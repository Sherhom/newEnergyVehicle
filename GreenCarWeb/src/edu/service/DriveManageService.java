package edu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.dao.DriveManageMapper;
import edu.domain.CarCollisionBean;
import edu.domain.CarOverLoadBean;
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
    	System.out.println("*****service*******");
    	System.out.println(startDate);
    	System.out.println(endDate);
        System.out.println(keyword);
    	List<CarOverSpeedBean> temp=driveManageMapper.getOverSpeedInfo_mapper(startDate, endDate, keyword);
    	
    	return temp;
    	
    }
    
    public List<CarOverLoadBean> getOverLoadInfo(String startDate,String endDate,String keyword){
    	List<CarOverLoadBean> temp=driveManageMapper.getOverLoadInfo_mapper(startDate, endDate, keyword);
    	return temp;
    }
    
    public List<CarCollisionBean> getCollisionInfo(String startDate,String endDate,String keyword){
    	List<CarCollisionBean> temp=driveManageMapper.getCollisionInfo_mapper(startDate, endDate, keyword);
    	return temp;
    }
}
