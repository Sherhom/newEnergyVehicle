package edu.domain;

public class AddCarTeamInfoBean {
	private String motorcadeNum;
	private String captainNum;
	private int motorcadeMount;
	public AddCarTeamInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddCarTeamInfoBean(String motorcadeNum, String captainNum, int motorcadeMount) {
		super();
		this.motorcadeNum = motorcadeNum;
		this.captainNum = captainNum;
		this.motorcadeMount = motorcadeMount;
	}
	@Override
	public String toString() {
		return "AddCarInfoBean [motorcadeNum=" + motorcadeNum + ", captainNum=" + captainNum + ", motorcadeMount="
				+ motorcadeMount + "]";
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
	
	
}
