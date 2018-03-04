package edu.dao;

import java.util.List;

import edu.domain.CarOpDataBean;
import edu.domain.GuaInfoBean;

public interface CarManageMapper {

	List<CarOpDataBean> getAllOpData_mapper();

	List<CarOpDataBean> getOpDataByCarNum_mapper(String carNum);

	List<CarOpDataBean> getOpDataByMotorcadeNum_mapper(String motorcadeNum);

	List<GuaInfoBean> getGuaInfo_mapper(String carNum);

}
