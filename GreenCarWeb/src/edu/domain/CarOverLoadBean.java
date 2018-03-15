package edu.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class CarOverLoadBean {
	private String carNum;
	private String driverNum;
	private String driverName;
	private Timestamp times;
	private double limitLoad;
	private double actualLoad;
	private int ident;
	public CarOverLoadBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarOverLoadBean(String carNum, String driverNum, String driverName, Timestamp times, double limitLoad,
			double actualLoad, int ident) {
		super();
		this.carNum = carNum;
		this.driverNum = driverNum;
		this.driverName = driverName;
		this.times = times;
		this.limitLoad = limitLoad;
		this.actualLoad = actualLoad;
		this.ident = ident;
	}
	@Override
	public String toString() {
		return "CarOverLoadBean [carNum=" + carNum + ", driverNum=" + driverNum + ", driverName=" + driverName
				+ ", times=" + times + ", limitLoad=" + limitLoad + ", actualLoad=" + actualLoad + ", ident=" + ident
				+ "]";
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
	public Timestamp getTimes() {
		return times;
	}
	public void setTimes(Timestamp times) {
		this.times = times;
	}
	public double getLimitLoad() {
		return limitLoad;
	}
	public void setLimitLoad(double limitLoad) {
		this.limitLoad = limitLoad;
	}
	public double getActualLoad() {
		return actualLoad;
	}
	public void setActualLoad(double actualLoad) {
		this.actualLoad = actualLoad;
	}
	public int getIdent() {
		return ident;
	}
	public void setIdent(int ident) {
		this.ident = ident;
	}
	
	
	
	
	
}
