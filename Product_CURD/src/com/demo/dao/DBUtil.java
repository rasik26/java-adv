package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection con;
	public static Connection getMyConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://192.168.10.150:3306/dac17?useSSL=false";
			con = DriverManager.getConnection(url, "dac17", "welcome");
			if(con != null)
				System.out.println("Connected !!");
			
		} catch (SQLException e) {
			System.out.println("Error : "+e.getMessage());
		}
		return con;
	}
	
	public static void closeMyConnection() {
		if(con != null)
			try {
				if(con != null)
				con.close();
			} catch (SQLException e) {
				System.out.println("Error : "+e.getMessage());
			}
	}
}
