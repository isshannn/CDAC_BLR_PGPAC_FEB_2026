package com.ved.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ved.util.DBConnection;

public class LoginDAO {

	public boolean validate(String username, String password) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from login where username=? and password=?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
}