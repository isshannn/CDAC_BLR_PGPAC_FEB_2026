package com.ved;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnect {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		///Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/veddb";
		String username="root";
		String password="password";
		Connection con=DriverManager.getConnection(url, username, password);
		System.out.println(con);
	}

}
