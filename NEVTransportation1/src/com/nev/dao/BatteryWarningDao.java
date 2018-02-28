package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;



public class BatteryWarningDao {
	
	private static final String BATTERYWARNING = "batteryWarning";

	public void addBatteryWarning(String batteryNum, int bmsWarn, String warnDes, Timestamp times){
		
		String sql = "insert into " + BATTERYWARNING + "(batteryNum,"
					+ " bmsWarn, warnDes, times) values(?,?,?,?)";
		
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, batteryNum);
			ps.setInt(2, bmsWarn);
			ps.setString(3, warnDes);
			ps.setTimestamp(4, times);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
