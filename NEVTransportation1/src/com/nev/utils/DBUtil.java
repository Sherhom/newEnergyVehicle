package com.nev.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	private static String dbdriver;
	private static String dburl;
	private static String username;
	private static String password;
		
	static {
		/*Properties prop = new Properties();
		Reader in;
		try {
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (Exception e) {				
			e.printStackTrace();
		}*/
		
		//dbdriver = prop.getProperty("dbdriver");
		//dburl = prop.getProperty("dburl");
		//username = prop.getProperty("username");
		//password = prop.getProperty("password");
		
		dbdriver = "com.mysql.jdbc.Driver";
		dburl = "jdbc:mysql://localhost:3306/nev?characterEncoding=utf8&useSSL=false";
		username = "root";
		password = "root";
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(dbdriver).newInstance();
			return DriverManager.getConnection(dburl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
