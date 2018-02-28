package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;

public class CarOverLoadDao {
	
	private static final String CAROVERLOAD = "carOverLoad";
	
	public void addCarOverLoad(String carNum, double limitLoad, double actualLoad, int ident, Timestamp times){
		
		String sql = "insert into " + CAROVERLOAD + "(carNum, limitLoad, actualLoad, ident, times) "
					+ "values(?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, carNum);
			ps.setDouble(2, limitLoad);
			ps.setDouble(3, actualLoad);
			ps.setInt(4, ident);
			ps.setTimestamp(5, times);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
