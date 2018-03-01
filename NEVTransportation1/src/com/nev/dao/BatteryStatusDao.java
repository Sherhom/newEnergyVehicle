package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;

public class BatteryStatusDao extends Dao{

	private static final String BATTERYSTATUS = "batteryStatus";
	
	/*
	public static void add(String batteryNum, double batteryTem, double totalVoltage,
								int levelAlarm, int isUse, double current, double soc,
								double extremeData, double temData, double MonomerV, Timestamp times){
	*/
	public static void add(String []message,  Timestamp times){
		String sql = "insert into " + BATTERYSTATUS + "(batteryNum, batteryNum, totalVoltage,levelAlarm,"
				+ "	 isUse,current,soc,extremeData,temData,MonomerV,times) values(?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			/*
			ps.setString(1, batteryNum);
			ps.setDouble(2, batteryTem);
			ps.setDouble(3, totalVoltage);
			ps.setInt(4, levelAlarm);
			ps.setInt(5, isUse);
			ps.setDouble(6, current);
			ps.setDouble(7, soc);
			ps.setDouble(8, extremeData);
			ps.setDouble(9, temData);
			ps.setDouble(10, MonomerV);
			ps.setTimestamp(11, times);
			*/
			ps.setString(1,message[1]);
			ps.setDouble(2,Double.parseDouble(message[2]));
			ps.setDouble(3,Double.parseDouble(message[3]));
			ps.setInt(4, Integer.parseInt(message[4]));
			ps.setInt(5, Integer.parseInt(message[5]));
			ps.setDouble(6, Double.parseDouble(message[6]));
			ps.setDouble(7, Double.parseDouble(message[7]));
			ps.setDouble(8, Double.parseDouble(message[8]));
			ps.setDouble(9, Double.parseDouble(message[9]));
			ps.setDouble(10, Double.parseDouble(message[10]));
			ps.setTimestamp(11, times);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
