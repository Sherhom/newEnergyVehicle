package edu.domain;

public class Driver {
	int driverId;
	String driverNum, motorcadeNum, carNum, driverName;
	int driverSex;
	String driverPhone, driverPosition;
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverNum() {
		return driverNum;
	}
	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}
	public String getMotorcadeNum() {
		return motorcadeNum;
	}
	public void setMotorcadeNum(String motorcadeNum) {
		this.motorcadeNum = motorcadeNum;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public int getDriverSex() {
		return driverSex;
	}
	public void setDriverSex(int driverSex) {
		this.driverSex = driverSex;
	}
	public String getDriverPhone() {
		return driverPhone;
	}
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
	public String getDriverPosition() {
		return driverPosition;
	}
	public void setDriverPosition(String driverPosition) {
		this.driverPosition = driverPosition;
	}
	public Driver(int driverId, String driverNum, String motorcadeNum, String carNum, String driverName, int driverSex,
			String driverPhone, String driverPosition) {
		super();
		this.driverId = driverId;
		this.driverNum = driverNum;
		this.motorcadeNum = motorcadeNum;
		this.carNum = carNum;
		this.driverName = driverName;
		this.driverSex = driverSex;
		this.driverPhone = driverPhone;
		this.driverPosition = driverPosition;
	}
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverNum=" + driverNum + ", motorcadeNum=" + motorcadeNum
				+ ", carNum=" + carNum + ", driverName=" + driverName + ", driverSex=" + driverSex + ", driverPhone="
				+ driverPhone + ", driverPosition=" + driverPosition + "]";
	}
	
}
