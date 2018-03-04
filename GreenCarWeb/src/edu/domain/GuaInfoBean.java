package edu.domain;

import java.sql.Date;

public class GuaInfoBean {
	private String carNum;
	private double mainPeriod;
	private String mainDes;
	private Date times;
	
	
	
	public GuaInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GuaInfoBean(String carNum, double mainPeriod, String mainDes, Date times) {
		super();
		this.carNum = carNum;
		this.mainPeriod = mainPeriod;
		this.mainDes = mainDes;
		this.times = times;
	}
	
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public double getMainPeriod() {
		return mainPeriod;
	}
	public void setMainPeriod(double mainPeriod) {
		this.mainPeriod = mainPeriod;
	}
	public String getMainDes() {
		return mainDes;
	}
	public void setMainDes(String mainDes) {
		this.mainDes = mainDes;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}
	@Override
	public String toString() {
		return "GuaInfoBean [carNum=" + carNum + ", mainPeriod=" + mainPeriod + ", mainDes=" + mainDes + ", times="
				+ times + "]";
	}
	
	
}
