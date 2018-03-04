package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;

public class CarOverSpeedDao extends Dao{
	
	private static final String CAROVERSPEED= "carOverSpeed";
	/*
	public static void add(String carNum, double limitSpeed, double maxSpeed,
								int statusIdent, Timestamp times){
	*/
	
	@Override
	public void add(String[] message ,Timestamp times){
		
		String sql = "insert into " + CAROVERSPEED + "(carNum, limitSpeed, maxSpeed, statusIdent, times) values"
					+ "(?,?,?,?,?)";
		
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			/*ps.setString(1, carNum);
			ps.setDouble(2, limitSpeed);
			ps.setDouble(3, maxSpeed);
			ps.setInt(4, statusIdent);
			ps.setTimestamp(5, times);*/
			
			ps.setString(1, message[1]);
			ps.setDouble(2, Double.parseDouble(message[2]));
			ps.setDouble(3, Double.parseDouble(message[3]));
			ps.setInt(4, Integer.parseInt(message[4]));
			ps.setTimestamp(5, times);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
