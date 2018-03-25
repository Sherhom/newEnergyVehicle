package edu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.dao.CarTeamInfoMapper;
import edu.domain.AddCarTeamInfoBean;
import edu.domain.CarTeamInfoBean;

@Service
public class CarTeamInfoService {
	
	@Resource
	CarTeamInfoMapper carTeamInfoMapper;
	
	
	public List<CarTeamInfoBean> getCarTeamInfo_service(String keyword){
		List<CarTeamInfoBean> temp=carTeamInfoMapper.getCarTeamInfo_mapper(keyword);
		return temp;
	}
	
	public void addCarTeamInfo_service(AddCarTeamInfoBean ctb){
		carTeamInfoMapper.addCarTeamInfo_mapper(ctb);
	}
}