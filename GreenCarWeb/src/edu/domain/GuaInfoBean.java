package edu.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class GuaInfoBean {
	private String carNum;
	private double mainPeriod;
	private String mainDes;
	private Timestamp times;
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
    public Timestamp getTimes() {
        return times;
    }
    public void setTimes(Timestamp times) {
        this.times = times;
    }
    public GuaInfoBean(String carNum, double mainPeriod, String mainDes, Timestamp times) {
        super();
        this.carNum = carNum;
        this.mainPeriod = mainPeriod;
        this.mainDes = mainDes;
        this.times = times;
    }
    public GuaInfoBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "GuaInfoBean [carNum=" + carNum + ", mainPeriod=" + mainPeriod + ", mainDes=" + mainDes + ", times="
                + times + "]";
    }
	
	
	
	
}
