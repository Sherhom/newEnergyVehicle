package edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.domain.Battery;

public interface BatteryMapper {
	//根据是否需要显示关联查询电池
	List<Battery> getBatteryInfoShowDetached(int limit, int offset);
	List<Battery> getBatteryInfoNotShowDetached(int limit, int offset);
	int getBatteryCountShowDetached();
	int getBatteryCountNotShowDetached();
}
