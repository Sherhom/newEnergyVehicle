package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;

public class CarSpeedDao {
	
	private static final String CARSPEED = "carSpeed";
	
	public void addCarSpeed(String carNum, double waterTem, double engineTem, double revSpeed,
							double driSpeed, String gear, Timestamp times){
		
		String sql = "insert into " + CARSPEED + "(carNum,waterTem,engineTem,"
					+ "revSpeed,driSpeed,gear,times) values(?,?,?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, carNum);
			ps.setDouble(2, waterTem);
			ps.setDouble(3, engineTem);
			ps.setDouble(4, revSpeed);
			ps.setDouble(5, driSpeed);
			ps.setString(6, gear);
			ps.setTimestamp(7, times);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
