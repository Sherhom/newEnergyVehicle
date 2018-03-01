package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;



public class BatteryWarningDao extends Dao{
	
	private static final String BATTERYWARNING = "batteryWarning";
	/*
	public static void add(String batteryNum, int bmsWarn, String warnDes, Timestamp times){
	*/	
	public static void add(String[] message, Timestamp times){
		String sql = "insert into " + BATTERYWARNING + "(batteryNum,"
					+ " bmsWarn, warnDes, times) values(?,?,?,?)";
		
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, message[1]);
			ps.setInt(2, Integer.parseInt(message[2]));
			ps.setString(3, message[3]);
			ps.setTimestamp(4, times);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
