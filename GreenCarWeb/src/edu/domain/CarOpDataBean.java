package edu.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class CarOpDataBean {
	private String carNum;
	private String motorcadeNum;
	private String driverName;
	private String carBrand;
	private double carryingCapacity;
	private Timestamp dataManu;
	private String batteryNum;
	private Timestamp times;
	private double totalMile;
    public String getCarNum() {
        return carNum;
    }
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
    public String getMotorcadeNum() {
        return motorcadeNum;
    }
    public void setMotorcadeNum(String motorcadeNum) {
        this.motorcadeNum = motorcadeNum;
    }
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public String getCarBrand() {
        return carBrand;
    }
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
    public double getCarryingCapacity() {
        return carryingCapacity;
    }
    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
    public Timestamp getDataManu() {
        return dataManu;
    }
    public void setDataManu(Timestamp dataManu) {
        this.dataManu = dataManu;
    }
    public String getBatteryNum() {
        return batteryNum;
    }
    public void setBatteryNum(String batteryNum) {
        this.batteryNum = batteryNum;
    }
    public Timestamp getTimes() {
        return times;
    }
    public void setTimes(Timestamp times) {
        this.times = times;
    }
    public double getTotalMile() {
        return totalMile;
    }
    public void setTotalMile(double totalMile) {
        this.totalMile = totalMile;
    }
    @Override
    public String toString() {
        return "CarOpDataBean [carNum=" + carNum + ", motorcadeNum=" + motorcadeNum + ", driverName=" + driverName
                + ", carBrand=" + carBrand + ", carryingCapacity=" + carryingCapacity + ", dataManu=" + dataManu
                + ", batteryNum=" + batteryNum + ", times=" + times + ", totalMile=" + totalMile + "]";
    }
    public CarOpDataBean(String carNum, String motorcadeNum, String driverName, String carBrand,
            double carryingCapacity, Timestamp dataManu, String batteryNum, Timestamp times, double totalMile) {
        super();
        this.carNum = carNum;
        this.motorcadeNum = motorcadeNum;
        this.driverName = driverName;
        this.carBrand = carBrand;
        this.carryingCapacity = carryingCapacity;
        this.dataManu = dataManu;
        this.batteryNum = batteryNum;
        this.times = times;
        this.totalMile = totalMile;
    }
    public CarOpDataBean() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	
	
	
}