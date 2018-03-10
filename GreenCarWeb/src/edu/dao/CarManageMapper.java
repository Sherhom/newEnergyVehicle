package edu.dao;

import java.util.List;

import edu.domain.CarLocationBean;
import edu.domain.CarOpDataBean;
import edu.domain.GuaInfoBean;
import edu.domain.TaskInfoBean;

public interface CarManageMapper {

	List<CarOpDataBean> getAllOpData_mapper();

	List<CarOpDataBean> getOpDataByCarNum_mapper(String carNum);

	List<CarOpDataBean> getOpDataByMotorcadeNum_mapper(String motorcadeNum);

	List<GuaInfoBean> getGuaInfo_mapper(String carNum);

	List<TaskInfoBean> getTaskInfo_mapper(String motorcadeNum);

	List<CarLocationBean> getLocationInfo_mapper(String carNum);

}
