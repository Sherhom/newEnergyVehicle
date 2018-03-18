package edu.domain;

public class CarTeamInfoBean {
	private String motorcadeNum;
	private String captainNum;
	private String driverName;
	private String driverPhone;
	private int motorcadeMount;
	public CarTeamInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarTeamInfoBean(String motorcadeNum, String captainNum, String driverName, String driverPhone,
			int motorcadeMount) {
		super();
		this.motorcadeNum = motorcadeNum;
		this.captainNum = captainNum;
		this.driverName = driverName;
		this.driverPhone = driverPhone;
		this.motorcadeMount = motorcadeMount;
	}
	@Override
	public String toString() {
		return "CarTeamInfoBean [motorcadeNum=" + motorcadeNum + ", captainNum=" + captainNum + ", driverName="
				+ driverName + ", driverPhone=" + driverPhone + ", motorcadeMount=" + motorcadeMount + "]";
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
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverPhone() {
		return driverPhone;
	}
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
	public int getMotorcadeMount() {
		return motorcadeMount;
	}
	public void setMotorcadeMount(int motorcadeMount) {
		this.motorcadeMount = motorcadeMount;
	}
	
	
}
