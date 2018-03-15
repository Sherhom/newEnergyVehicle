package edu.domain;

public class Battery {
	String batteryNum,batteryBrand,batteryVersion,carNum;

	public String getBatteryNum() {
		return batteryNum;
	}

	public void setBatteryNum(String batteryNum) {
		this.batteryNum = batteryNum;
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

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public Battery(String batteryNum, String batteryBrand, String batteryVersion, String carNum) {
		super();
		this.batteryNum = batteryNum;
		this.batteryBrand = batteryBrand;
		this.batteryVersion = batteryVersion;
		this.carNum = carNum;
	}

	public Battery() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Battery [batteryNum=" + batteryNum + ", batteryBrand=" + batteryBrand + ", batteryVersion="
				+ batteryVersion + ", carNum=" + carNum + "]";
	}
	
}
