package edu.domain;

import java.sql.Date;

public class CarLocationBean {
	private String carNum;
	private double longtitude;
	private double latitude;
	private Date times;
	
	
	public CarLocationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CarLocationBean(String carNum, double longtitude, double latitude, Date times) {
		super();
		this.carNum = carNum;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.times = times;
	}

	@Override
	public String toString() {
		return "CarLocationBean [carNum=" + carNum + ", longtitude=" + longtitude + ", latitude=" + latitude
				+ ", times=" + times + "]";
	}

	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}
	
	
}
