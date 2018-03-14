package edu.model;

import edu.domain.Battery;
import edu.domain.Car;

public class BatteryMatainTable {
	String batteryNum;
	String isCorrelated;
	String carNum,batteryBrand,batteryVersion;
	
	public BatteryMatainTable(Car car,Battery battery){
		batteryNum = battery.getBatteryNum();
		batteryBrand = battery.getBatteryBrand();
		batteryVersion = battery.getBatteryVersion();
		if(car != null) {
			carNum =  car.getCarNum();
		}
		if(battery.getCarNum() != null && car != null && battery.getCarNum() == car.getCarNum()) {
			isCorrelated = "Correlated";
		}else {
			isCorrelated = "Not Correlated";
		}
	}

	public String getBatteryNum() {
		return batteryNum;
	}

	public void setBatteryNum(String batteryNum) {
		this.batteryNum = batteryNum;
	}

	public String getIsCorrelated() {
		return isCorrelated;
	}

	public void setIsCorrelated(String isCorrelated) {
		this.isCorrelated = isCorrelated;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getBatteryBrand() {
		return batteryBrand;
	}

	public void setBatteryBrand(String batteryBrand) {
		this.batteryBrand = batteryBrand;
	}

	public String getBatteryVersion() {
		return batteryVersion;
	}

	public void setBatteryVersion(String batteryVersion) {
		this.batteryVersion = batteryVersion;
	}
	
	

}
