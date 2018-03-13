package edu.domain;

import java.sql.Date;

public class CarCollisionBean {
	private String carNum;
	private String driverNum;
	private String driverName;
	private Date times;
	private int collRank;
	private double limitValue;
	private double actualValue;
	private double collAngel;
	
	public CarCollisionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CarCollisionBean(String carNum, String driverNum, String driverName, Date times, int collRank,
			double limitValue, double actualValue, double collAngel) {
		super();
		this.carNum = carNum;
		this.driverNum = driverNum;
		this.driverName = driverName;
		this.times = times;
		this.collRank = collRank;
		this.limitValue = limitValue;
		this.actualValue = actualValue;
		this.collAngel = collAngel;
	}
	
	@Override
	public String toString() {
		return "CarCollisionBean [carNum=" + carNum + ", driverNum=" + driverNum + ", driverName=" + driverName
				+ ", times=" + times + ", collRank=" + collRank + ", limitValue=" + limitValue + ", actualValue="
				+ actualValue + ", collAngel=" + collAngel + "]";
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
	public int getCollRank() {
		return collRank;
	}
	public void setCollRank(int collRank) {
		this.collRank = collRank;
	}
	public double getLimitValue() {
		return limitValue;
	}
	public void setLimitValue(double limitValue) {
		this.limitValue = limitValue;
	}
	public double getActualValue() {
		return actualValue;
	}
	public void setActualValue(double actualValue) {
		this.actualValue = actualValue;
	}
	public double getCollAngel() {
		return collAngel;
	}
	public void setCollAngel(double collAngel) {
		this.collAngel = collAngel;
	}
	
	
	
	
}
