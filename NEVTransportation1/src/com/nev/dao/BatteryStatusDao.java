package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;

public class BatteryStatusDao {

	private static final String BATTERYSTATUS = "batteryStatus";
	
	public void addBatteryStatus(String batteryNum, double batteryTem, double totalVoltage,
								int levelAlarm, int isUse, double current, double soc,
								double extremeData, double temData, double MonomerV, Timestamp times){
		String sql = "insert into " + BATTERYSTATUS + "(batteryNum, batteryNum, totalVoltage,levelAlarm,"
				+ "	 isUse,current,soc,extremeData,temData,MonomerV,times) values(?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
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
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
