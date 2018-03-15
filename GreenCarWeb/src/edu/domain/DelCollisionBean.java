package edu.domain;

import java.sql.Date;

public class DelCollisionBean {
	private String carNum;
	private String times;
	private double actualValue;
	public DelCollisionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DelCollisionBean(String carNum, String times, double actualValue) {
		super();
		this.carNum = carNum;
		this.times = times;
		this.actualValue = actualValue;
	}
	@Override
	public String toString() {
		return "DelCollisionBean [carNum=" + carNum + ", times=" + times + ", actualValue=" + actualValue + "]";
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
	public double getActualValue() {
		return actualValue;
	}
	public void setActualValue(double actualValue) {
		this.actualValue = actualValue;
	}
	
	
	
	
}
