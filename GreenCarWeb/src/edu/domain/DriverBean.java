package edu.domain;

public class DriverBean {
	private String driverNum;
	private String motorcadeNum;
	private String carNum;
	private String driverName;
	private int driverSex;
	private String driverPhone;
	private String driverPosition;
	
	public DriverBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DriverBean(String driverNum, String motorcadeNum, String carNum, String driverName, int driverSex,
			String driverPhone, String driverPosition) {
		super();
		this.driverNum = driverNum;
		this.motorcadeNum = motorcadeNum;
		this.carNum = carNum;
		this.driverName = driverName;
		this.driverSex = driverSex;
		this.driverPhone = driverPhone;
		this.driverPosition = driverPosition;
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
	@Override
	public String toString() {
		return "DriverBean [driverNum=" + driverNum + ", motorcadeNum=" + motorcadeNum + ", carNum=" + carNum
				+ ", driverName=" + driverName + ", driverSex=" + driverSex + ", driverPhone=" + driverPhone
				+ ", driverPosition=" + driverPosition + "]";
	}
	
	
}
