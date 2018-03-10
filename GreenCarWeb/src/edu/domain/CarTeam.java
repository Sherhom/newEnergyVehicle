package edu.domain;

public class CarTeam {
	int motorcadeId;
	String motorcadeNum,captainNum;
	int motorcadeMount;
	public int getMotorcadeId() {
		return motorcadeId;
	}
	public void setMotorcadeId(int motorcadeId) {
		this.motorcadeId = motorcadeId;
	}
	public String getMotorcadeNum() {
		return motorcadeNum;
	}
	public void setMotorcadeNum(String motorcadeNum) {
		this.motorcadeNum = motorcadeNum;
	}
	public String getCaptainNum() {
		return captainNum;
	}
	public void setCaptainNum(String captainNum) {
		this.captainNum = captainNum;
	}
	public int getMotorcadeMount() {
		return motorcadeMount;
	}
	public void setMotorcadeMount(int motorcadeMount) {
		this.motorcadeMount = motorcadeMount;
	}
	@Override
	public String toString() {
		return "CarTeam [motorcadeId=" + motorcadeId + ", motorcadeNum=" + motorcadeNum + ", captainNum=" + captainNum
				+ ", motorcadeMount=" + motorcadeMount + "]";
	}
	
}
