package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;


public class CarSocDao extends Dao{
	
	private static final String CARSOC = "carSoc";
	/*
	public static void add(String carNum, double limitValue, double soc, 
						  int statusIdent, Timestamp times, String batteryNum){
	*/
	
	
	@Override
	public void add(String[] message ,Timestamp times){
		
		String sql = "insert into " + CARSOC + "(carNum, limitValue, soc, statusIdent, "
					 + "times, batteryNum)values(?,?,?,?,?,?)";
		
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			/*ps.setString(1, carNum);
			ps.setDouble(2, limitValue);
			ps.setDouble(3, soc);
			ps.setInt(4, statusIdent);
			ps.setTimestamp(5, times);
			ps.setString(6, batteryNum);*/
			
			ps.setString(1, message[1]);
			ps.setDouble(2, Double.parseDouble(message[2]));
			ps.setDouble(3, Double.parseDouble(message[3]));
			ps.setInt(4, Integer.parseInt(message[4]));
			ps.setTimestamp(5, times);
			ps.setString(6, message[5]);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
