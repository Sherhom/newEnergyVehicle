package edu.domain;

import java.sql.Timestamp;

public class WorkRecordBean {
	private String carNum;
	private String driverNum;
	private String driverName;
	private Timestamp commitTime;
	private Timestamp endTime;
	private double workDuration;
	private double workMileage;
	private String taskDes;
	private double moveDuration;
	public WorkRecordBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkRecordBean(String carNum, String driverNum, String driverName, Timestamp commitTime, Timestamp endTime,
			double workDuration, double workMileage, String taskDes, double moveDuration) {
		super();
		this.carNum = carNum;
		this.driverNum = driverNum;
		this.driverName = driverName;
		this.commitTime = commitTime;
		this.endTime = endTime;
		this.workDuration = workDuration;
		this.workMileage = workMileage;
		this.taskDes = taskDes;
		this.moveDuration = moveDuration;
	}
	@Override
	public String toString() {
		return "WorkRecordBean [carNum=" + carNum + ", driverNum=" + driverNum + ", driverName=" + driverName
				+ ", commitTime=" + commitTime + ", endTime=" + endTime + ", workDuration=" + workDuration
				+ ", workMileage=" + workMileage + ", taskDes=" + taskDes + ", moveDuration=" + moveDuration + "]";
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
	public Timestamp getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(Timestamp commitTime) {
		this.commitTime = commitTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public double getWorkDuration() {
		return workDuration;
	}
	public void setWorkDuration(double workDuration) {
		this.workDuration = workDuration;
	}
	public double getWorkMileage() {
		return workMileage;
	}
	public void setWorkMileage(double workMileage) {
		this.workMileage = workMileage;
	}
	public String getTaskDes() {
		return taskDes;
	}
	public void setTaskDes(String taskDes) {
		this.taskDes = taskDes;
	}
	public double getMoveDuration() {
		return moveDuration;
	}
	public void setMoveDuration(double moveDuration) {
		this.moveDuration = moveDuration;
	}
	
	
	
	
	
}
