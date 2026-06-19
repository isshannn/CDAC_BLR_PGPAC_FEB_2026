package com.ved.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/veddb";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "password";
	private static Connection con = null;

	public static Connection getConnection() throws SQLException {
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return con;
	}
	public static void close(AutoCloseable resource) {  //AutoCloseable  is parent class of Connection.class, Statement.class
		try {
			if (resource != null) {
				resource.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}