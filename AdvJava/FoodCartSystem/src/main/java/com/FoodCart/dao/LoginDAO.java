package com.FoodCart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.FoodCart.util.DBConnection;

public class LoginDAO {

	public boolean validate(String userName, String passWord) {

		// Check User entered credentials with DB stored credentials;

		boolean status = false;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement p_stmt = con.prepareStatement("select * from users where username = ? and password = ?");

			System.out.println("LoginDAO Debug :: userName = "+ userName);
			System.out.println("LoginDAO Debug :: password = "+ passWord);

			p_stmt.setString(1,userName);
			p_stmt.setString(2,passWord);

			ResultSet rs = p_stmt.executeQuery();

			status = rs.next();
			System.out.println("LoginDAO Debug :: login_status = "+ status);
		}catch(Exception e) {
			System.out.println("LoginDAO :: QueryExeution Error :: " + e.getMessage());
		}
		return status;
	}

}
