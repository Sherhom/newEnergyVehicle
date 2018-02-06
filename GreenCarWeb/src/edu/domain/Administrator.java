package edu.domain;

public class Administrator {
	int adminId;
	String adminNum,adminName,adminAccount,adminPass,adminPhone;
	public Administrator(int adminId, String adminNum, String adminName, String adminAccount, String adminPass,
			String adminPhone) {
		super();
		this.adminId = adminId;
		this.adminNum = adminNum;
		this.adminName = adminName;
		this.adminAccount = adminAccount;
		this.adminPass = adminPass;
		this.adminPhone = adminPhone;
	}
	public Administrator() {
		super();
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(String adminNum) {
		this.adminNum = adminNum;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	@Override
	public String toString() {
		return "Administrator [adminId=" + adminId + ", adminNum=" + adminNum + ", adminName=" + adminName
				+ ", adminAccount=" + adminAccount + ", adminPass=" + adminPass + ", adminPhone=" + adminPhone + "]";
	}
}
