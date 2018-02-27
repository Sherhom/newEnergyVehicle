package edu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.dao.AdminMapper;
import edu.domain.Administrator;

@Service
public class AdminService {
	@Resource
	AdminMapper adminMapper;
	/**
	 * 
	 * @param username
	 * @param password
	 * @return 用户名密码正确时返回相应用户对象,验证错误时返回null
	 */
	public Administrator verifyAdmin(String username,String password) {
		if("".equals(username) || username == null) {
			return null;
		}
		Administrator administrator = adminMapper.getAdminByAccount(username);
		if(administrator == null) {
			return null;
		}
		if(!administrator.getAdminPass().equals(password)) {
			return null;
		}
		return administrator;
	}
	
}
