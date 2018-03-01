package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;


public class CarCollisionDao extends Dao{
	
	private static final String CARCOLLISION = "carCollision";
	/*
	public static void add(String carNum, int collRank, double limitValue, 
								double actualValue, double collAngle, Timestamp times){
	*/	
	public static void add(String []message, Timestamp times){
		String sql = "insert into " + CARCOLLISION + "(carNum, collRank, limitValue, actualValue, collAngle, times)"
				+ "values(?,?,?,?,?,?)";
		
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, message[1]);
			ps.setInt(2, Integer.parseInt(message[2]));
			ps.setDouble(3, Double.parseDouble(message[3]));
			ps.setDouble(4, Double.parseDouble(message[4]));
			ps.setDouble(5, Double.parseDouble(message[5]));
			ps.setTimestamp(6, times);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
