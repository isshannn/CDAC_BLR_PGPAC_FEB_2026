package com.ved.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitializer {

	public static void createDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "password");

			Statement st = con.createStatement();

			st.executeUpdate("CREATE DATABASE IF NOT EXISTS librarydb");

			con.close();

			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "password");

			Statement dbSt = dbCon.createStatement();

			dbSt.executeUpdate("CREATE TABLE IF NOT EXISTS login(" + "username varchar(20)," + "password varchar(20))");

			dbSt.executeUpdate("CREATE TABLE IF NOT EXISTS book(" + "bid int primary key," + "bname varchar(50),"
					+ "author varchar(50)," + "price double)");

			dbSt.executeUpdate("INSERT IGNORE INTO login VALUES('admin','123')");

			dbCon.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}