package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;


public class CarMileDao extends Dao{
	
	private static final String CARMILE = "carMile";
	/*
	public static void add(double totalMile,int isCarLock, int isSeatLock, 
							int isSafetyBelt, int isHandBraking,
							Timestamp times, String carNum){
	*/
	public static void add(String[] message ,Timestamp times){
		String sql = "insert into " + CARMILE + "(totalMile,isCarLock,"
				     + "isSeatLock,isSafetyBelt,isHandBraking,times,carNum) values(?,?,?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			/*ps.setDouble(1, totalMile);
			ps.setInt(2, isCarLock);
			ps.setInt(3, isSeatLock);
			ps.setInt(4, isSafetyBelt);
			ps.setInt(5, isHandBraking);
			ps.setTimestamp(6, times);
			ps.setString(7, message[7]);*/
			
			ps.setDouble(1, Double.parseDouble(message[1]));
			ps.setInt(2, Integer.parseInt(message[2]));
			ps.setInt(3, Integer.parseInt(message[3]));
			ps.setInt(4, Integer.parseInt(message[4]));
			ps.setInt(5, Integer.parseInt(message[5]));
			ps.setTimestamp(6, times);
			ps.setString(7, message[6]);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
