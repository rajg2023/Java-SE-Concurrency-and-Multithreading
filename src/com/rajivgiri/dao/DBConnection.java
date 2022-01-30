package com.rajivgiri.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.*;

public class DBConnection {

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://SERVERNAME;databaseName=YOURDBNAMEHERE;user=USERNAME;password=PASSWORD");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println("Connected");
			}
		return conn;
	}
	
}
