package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;

public class CarOverSpeedDao {
	
	private static final String CAROVERSPEED= "carOverSpeed";
	
	public void addCarOverSpeed(String carNum, double limitSpeed, double maxSpeed,
								int statusIdent, Timestamp times){
		
		String sql = "insert into " + CAROVERSPEED + "(carNum, limitSpeed, maxSpeed, statusIdent, times) values"
					+ "(?,?,?,?,?)";
		
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, carNum);
			ps.setDouble(2, limitSpeed);
			ps.setDouble(3, maxSpeed);
			ps.setInt(4, statusIdent);
			ps.setTimestamp(5, times);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
