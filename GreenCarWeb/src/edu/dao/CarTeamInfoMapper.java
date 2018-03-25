package edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.domain.AddCarTeamInfoBean;
import edu.domain.CarTeamInfoBean;

public interface CarTeamInfoMapper {
	public List<CarTeamInfoBean> getCarTeamInfo_mapper(@Param("keyword")String keyword);
	
	public void addCarTeamInfo_mapper(AddCarTeamInfoBean ctb);
}
