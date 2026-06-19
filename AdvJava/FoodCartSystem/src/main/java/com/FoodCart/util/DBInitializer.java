package com.FoodCart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBInitializer {
	public static void createDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Samvas232");
			Statement st = con.createStatement();
//			st.executeUpdate("drop database samvas_advjava");
			st.executeUpdate("CREATE DATABASE IF NOT EXISTS samvas_advjava");
			con.close();

			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/samvas_advjava", "root", "Samvas232");
			Statement dbSt = dbCon.createStatement();
			dbSt.executeUpdate("CREATE TABLE IF NOT EXISTS users(username varchar(30) PRIMARY KEY, password varchar(30));");
			dbSt.executeUpdate("CREATE TABLE IF NOT EXISTS food_items(food_id int primary key auto_increment, food_name varchar(50) unique,price double);");
			dbSt.executeUpdate("CREATE TABLE IF NOT EXISTS orders(order_id int primary key auto_increment, username varchar(30),food_name varchar(30),quantity int, total_amount Double);");

			dbSt.executeUpdate("INSERT IGNORE INTO users VALUES('admin','admin123'),( 'user','user123' );");
			dbSt.executeUpdate("Insert ignore into food_items(food_name,price) Values ('Pizza',250), ('Burger',120), ('Sandwich',100);");

			dbCon.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
