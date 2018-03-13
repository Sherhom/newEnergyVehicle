package edu.domain;

import java.sql.Date;

public class CarOverSpeedBean {
	private String carNum;
	private String driverNum;
	private String driverName;
	private Date times;
	private double limitSpeed;
	private double maxSpeed;
	private int statusIdent;
	
	public CarOverSpeedBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CarOverSpeedBean(String carNum, String driverNum, String driverName, Date times, double limitSpeed,
			double maxSpeed, int statusIdent) {
		super();
		this.carNum = carNum;
		this.driverNum = driverNum;
		this.driverName = driverName;
		this.times = times;
		this.limitSpeed = limitSpeed;
		this.maxSpeed = maxSpeed;
		this.statusIdent = statusIdent;
	}
	
	@Override
	public String toString() {
		return "CarOverSpeedBean [carNum=" + carNum + ", driverNum=" + driverNum + ", driverName=" + driverName
				+ ", times=" + times + ", limitSpeed=" + limitSpeed + ", maxSpeed=" + maxSpeed + ", statusIdent="
				+ statusIdent + "]";
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getDriverNum() {
		return driverNum;
	}
	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}
	public double getLimitSpeed() {
		return limitSpeed;
	}
	public void setLimitSpeed(double limitSpeed) {
		this.limitSpeed = limitSpeed;
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public int getStatusIdent() {
		return statusIdent;
	}
	public void setStatusIdent(int statusIdent) {
		this.statusIdent = statusIdent;
	}
	
	
	
}
