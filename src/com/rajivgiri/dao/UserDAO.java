package com.rajivgiri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rajivgiri.beans.User;

public class UserDAO {
	
	public int saveUser(User user) {
		
		int rows = 0;
		
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO [dbo].[User]([ID],[name],[email]) VALUES ( ? ,  ? , ?)");
			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			rows=statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

}
