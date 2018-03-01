package edu.domain;

import java.sql.Date;

public class Car {
	String carNum, carBrand;
	Date dateManu;
	double carryingCapacity;
	int driverNum;
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public Date getDateManu() {
		return dateManu;
	}
	public void setDateManu(Date dateManu) {
		this.dateManu = dateManu;
	}
	public double getCarryingCapacity() {
		return carryingCapacity;
	}
	public void setCarryingCapacity(double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}
	public int getDriverNum() {
		return driverNum;
	}
	public void setDriverNum(int driverNum) {
		this.driverNum = driverNum;
	}
	public Car(String carNum, String carBrand, Date dateManu, double carryingCapacity, int driverNum) {
		super();
		this.carNum = carNum;
		this.carBrand = carBrand;
		this.dateManu = dateManu;
		this.carryingCapacity = carryingCapacity;
		this.driverNum = driverNum;
	}
	@Override
	public String toString() {
		return "Car [carNum=" + carNum + ", carBrand=" + carBrand + ", dateManu=" + dateManu + ", carryingCapacity="
				+ carryingCapacity + ", driverNum=" + driverNum + "]";
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
