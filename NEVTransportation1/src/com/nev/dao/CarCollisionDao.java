package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;


public class CarCollisionDao {
	
	private static final String CARCOLLISION = "carCollision";
	
	public void addCarCollision(String carNum, int collRank, double limitValue, 
								double actualValue, double collAngle, Timestamp times){
		
		String sql = "insert into " + CARCOLLISION + "(carNum, collRank, limitValue, actualValue, collAngle, times)"
				+ "values(?,?,?,?,?,?)";
		
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, carNum);
			ps.setInt(2, collRank);
			ps.setDouble(3, limitValue);
			ps.setDouble(4, actualValue);
			ps.setDouble(5, collAngle);
			ps.setTimestamp(6, times);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
