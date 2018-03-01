package edu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import edu.dao.CarManageMapper;
import edu.domain.CarOpDataBean;

@Service
public class CarManageService {
	@Resource
	CarManageMapper carManageMapper;
	public List<CarOpDataBean> getAllOpData(){
		List<CarOpDataBean> temp=carManageMapper.getAllOpData_mapper();
		return temp;
		
	}
}
