package edu.dao;

import edu.domain.Administrator;

public interface AdminMapper {
	public Administrator getAdminByAccount(String account);
	
	public void changePassword_m(String userName,String newPass);
}
