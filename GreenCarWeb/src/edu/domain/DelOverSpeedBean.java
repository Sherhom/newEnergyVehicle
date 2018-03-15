package edu.domain;

import java.sql.Date;

public class DelOverSpeedBean {
	private String carNum;
	private String times;
	private double maxSpeed;
	public DelOverSpeedBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DelOverSpeedBean(String carNum, String times, double maxSpeed) {
		super();
		this.carNum = carNum;
		this.times = times;
		this.maxSpeed = maxSpeed;
	}
	@Override
	public String toString() {
		return "DelOverSpeedBean [carNum=" + carNum + ", times=" + times + ", maxSpeed=" + maxSpeed + "]";
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	
	
	
}
