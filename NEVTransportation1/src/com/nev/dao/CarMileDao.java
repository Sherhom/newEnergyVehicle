package com.nev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.nev.utils.DBUtil;


public class CarMileDao {
	
	private static final String CARMILE = "carMile";
	
	public void addCarMile(double totalMile,int isCarLock, int isSeatLock, 
							int isSafetyBelt, int isHandBraking,
							Timestamp times, String carNum){
		String sql = "insert into " + CARMILE + "(totalMile,isCarLock,"
				     + "isSeatLock,isSafetyBelt,isHandBraking,times,carNum) values(?,?,?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, totalMile);
			ps.setInt(2, isCarLock);
			ps.setInt(3, isSeatLock);
			ps.setInt(4, isSafetyBelt);
			ps.setInt(5, isHandBraking);
			ps.setTimestamp(6, times);
			ps.setString(7, carNum);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
