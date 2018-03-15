package edu.domain;

import java.sql.Date;

public class DelOverLoadBean {
	private String carNum;
	private String times;
	private double actualLoad;
	public DelOverLoadBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DelOverLoadBean(String carNum, String times, double actualLoad) {
		super();
		this.carNum = carNum;
		this.times = times;
		this.actualLoad = actualLoad;
	}
	@Override
	public String toString() {
		return "DelOverLoadBean [carNum=" + carNum + ", times=" + times + ", actualLoad=" + actualLoad + "]";
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
	public double getActualLoad() {
		return actualLoad;
	}
	public void setActualLoad(double actualLoad) {
		this.actualLoad = actualLoad;
	}
	
	
	
}
