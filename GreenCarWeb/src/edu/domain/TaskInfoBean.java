package edu.domain;

import java.util.Date;

public class TaskInfoBean {
	private String motorcadeNum;
	private String taskNum;
	private Date commitTime;
	private Date endTime;
	private Date finishTime;
	private int finishStatus;
	private String taskDes;
	
	
	public TaskInfoBean(String motorcadeNum, String taskNum, Date commitTime, Date endTime, Date finishTime,
			int finishStatus, String taskDes) {
		super();
		this.motorcadeNum = motorcadeNum;
		this.taskNum = taskNum;
		this.commitTime = commitTime;
		this.endTime = endTime;
		this.finishTime = finishTime;
		this.finishStatus = finishStatus;
		this.taskDes = taskDes;
	}
	
	public TaskInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TaskInfoBean [motorcadeNum=" + motorcadeNum + ", taskNum=" + taskNum + ", commitTime=" + commitTime
				+ ", endTime=" + endTime + ", finishTime=" + finishTime + ", finishStatus=" + finishStatus
				+ ", taskDes=" + taskDes + "]";
	}

	public String getMotorcadeNum() {
		return motorcadeNum;
	}
	public void setMotorcadeNum(String motorcadeNum) {
		this.motorcadeNum = motorcadeNum;
	}
	public String getTaskNum() {
		return taskNum;
	}
	public void setTaskNum(String taskNum) {
		this.taskNum = taskNum;
	}
	public Date getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public int getFinishStatus() {
		return finishStatus;
	}
	public void setFinishStatus(int finishStatus) {
		this.finishStatus = finishStatus;
	}
	public String getTaskDes() {
		return taskDes;
	}
	public void setTaskDes(String taskDes) {
		this.taskDes = taskDes;
	}
	
	
}
