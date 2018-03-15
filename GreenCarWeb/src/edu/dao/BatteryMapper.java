package edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.domain.Battery;

public interface BatteryMapper {
	//根据batteryNum得到battery对象
	Battery getBatteryByBatteryNum(String batteryNum);
	Battery getBatteryByCarNum(String carNum);
	
	//根据是否需要显示关联查询电池
	List<Battery> getBatteryInfoShowDetached(int limit, int offset);
	List<Battery> getBatteryInfoNotShowDetached(int limit, int offset);
	//显示电池数量
	int getBatteryCountShowDetached();
	int getBatteryCountNotShowDetached();
	//设置电池的carNum值
	void setBatteryCarNum(String batteryNum,String carNum);
	//设置电池基本信息
	void setBatteryInfo(String batteryNum,String brand,String version);
	
	//删除电池信息
	void delBatteryByBatteryNum(String batteryNum);
	
	//添加电池信息
	void addBattery(String batteryNum,String brend,String version, String carNum);
}
