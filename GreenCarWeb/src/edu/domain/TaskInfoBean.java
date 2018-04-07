package edu.domain;

import java.sql.Timestamp;
import java.util.Date;

public class TaskInfoBean {
	private String motorcadeNum;
	private String taskNum;
	private Timestamp commitTime;
	private Timestamp endTime;
	private Timestamp finishTime;
	private int finishStatus;
	private String taskDes;
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
    public Timestamp getFinishTime() {
        return finishTime;
    }
    public void setFinishTime(Timestamp finishTime) {
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
    @Override
    public String toString() {
        return "TaskInfoBean [motorcadeNum=" + motorcadeNum + ", taskNum=" + taskNum + ", commitTime=" + commitTime
                + ", endTime=" + endTime + ", finishTime=" + finishTime + ", finishStatus=" + finishStatus
                + ", taskDes=" + taskDes + "]";
    }
    public TaskInfoBean(String motorcadeNum, String taskNum, Timestamp commitTime, Timestamp endTime,
            Timestamp finishTime, int finishStatus, String taskDes) {
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
	
	
	
}
