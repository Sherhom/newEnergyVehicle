package edu.dao;

import java.util.List;

import edu.domain.CarTeam;

public interface TeamMapper {
	//返回所有的车队信息
	List<CarTeam> getALLCarTeam();
	//返回车队的数量
	int getCarTeamCount();
}
