package edu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.dao.CarTeamInfoMapper;
import edu.dao.TeamMapper;
import edu.domain.CarTeamInfoBean;

@Service
public class CarTeamService {
	@Resource
	TeamMapper teamMapper;
	
	
	public List getCarTeamAll() {
		return teamMapper.getALLCarTeam();
	}
	
	
}
