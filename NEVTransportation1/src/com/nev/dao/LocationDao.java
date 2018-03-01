package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;


public class LocationDao extends Dao{

	private static final String LOCATION = "location";
	/*
	public static void add(String carNum, double carLng,double carLat, Timestamp times) {
	*/
	
	public static void add(String[] message ,Timestamp times){	
	
		String sql = "insert into " + LOCATION + " (carNum,carLng,carLat,times) values(?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			/*ps.setString(1, carNum);
			ps.setDouble(2, carLng);
			ps.setDouble(3, carLat);
			ps.setTimestamp(4, times);*/
			
			ps.setString(1, message[1]);
			ps.setDouble(2, Double.parseDouble(message[2]));
			ps.setDouble(3, Double.parseDouble(message[3]));
			ps.setTimestamp(4, times);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
