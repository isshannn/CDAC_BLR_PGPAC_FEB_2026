package com.FoodCart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class used to connect to local DB. Make sure to append the local DB name in the connection string

public class DBConnection {

	private static Connection con;

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/samvas_advjava", "root", "Samvas232");
		}catch(Exception e) {
			System.out.println("Database Connection :: " + e);
		}
		return con;
	}
}
