package edu.service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
import edu.dao.CarMapper;
import edu.dao.DriverMapper;
import edu.dao.TeamMapper;
import edu.domain.Car;
import edu.domain.CarTeam;
import edu.domain.Driver;
import edu.model.TreeViewModel;
=======
import edu.dao.CarTeamInfoMapper;
import edu.dao.TeamMapper;
import edu.domain.CarTeamInfoBean;
>>>>>>> 4533745e9fb99627f138439d7a7c215c34be15fd

@Service
public class CarTeamService {
	@Resource
	TeamMapper teamMapper;
	@Resource
	DriverMapper driverMapper;
	@Resource
	CarMapper carMapper;
	
	
	public List getCarTeamAll() {
		return teamMapper.getALLCarTeam();
	}
	
<<<<<<< HEAD
	public List<TreeViewModel> getCarTeamDetail() {
		List<CarTeam> carTeams = teamMapper.getALLCarTeam();
		List<TreeViewModel> result = new LinkedList<>();
		for(int i = 0,edge = carTeams.size(); i < edge; i++) {
			TreeViewModel teamNode = new TreeViewModel();
			int carTeamNum = carTeams.get(i).getMotorcadeId();
			teamNode.setText("TEAM"+carTeamNum);
			result.add(teamNode);
			List<Driver> drivers = driverMapper.getDriverByTeamNum(carTeamNum+"", 10000, 0);
			for(int j = 0,driverLength = drivers.size(); j < driverLength ;j++) {
				Car curCar = carMapper.getCarByDriverNum(drivers.get(j).getDriverNum());
				TreeViewModel carNode = new TreeViewModel();
				carNode.setText("Car"+curCar.getCarNum());
				result.get(i).getNodes().add(carNode);
			}
		}
		return result;
	}
=======
	
>>>>>>> 4533745e9fb99627f138439d7a7c215c34be15fd
}
