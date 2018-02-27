package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nev.utils.DBUtil;


public class LocationDao {
	private static final String LOCATION = "class";

	public void addDevice(String code, String name) {
		String sql = "insert into " + LOCATION + " (code,name) values(?,?)";
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
