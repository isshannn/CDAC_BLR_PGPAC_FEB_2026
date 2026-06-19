package com.ved.crud;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.ved.DTO.EmployeeDTO;

public class Crud {
	private Connection connection;
	private CallableStatement callableStatement = null;
	private ResultSet resultSet;

	public Crud() {
	}

	public void createTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			String q = "CREATE TABLE IF NOT EXISTS employee (" 
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "username VARCHAR(30) NOT NULL UNIQUE," 
					+ "password VARCHAR(30)," 
					+ "full_name VARCHAR(100),"
					+ "address VARCHAR(200)," 
					+ "salary INT" + ")";
			statement = connection.createStatement();
			statement.executeUpdate(q);
			System.out.println("Table Created Successfully!");
		} catch (Exception e) {
			System.out.println("Table Not Created!");
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	// 1. INSERT using CallableStatement
	public void insert(EmployeeDTO employeedto) throws SQLException {
		System.out.println("Insert Method Called!");
		String query = "{call sp_insert_employee(?, ?, ?, ?, ?)}";

		connection = ConnectionFactory.getConnection();
		callableStatement = connection.prepareCall(query);

		callableStatement.setString(1, employeedto.getUsername());
		callableStatement.setString(2, employeedto.getPassword());
		callableStatement.setString(3, employeedto.getFullname());
		callableStatement.setString(4, employeedto.getAddress());
		callableStatement.setInt(5, employeedto.getSalary());
		
		callableStatement.execute();
		System.out.println("Row Inserted via Stored Procedure!");

		ConnectionFactory.close(callableStatement);
		ConnectionFactory.close(connection);
	}

	// 2. READ using CallableStatement
	public void read(String username, String password) throws SQLException {
		System.out.println("Read Method Called");
		String query = "{call sp_read_employee(?, ?)}";

		connection = ConnectionFactory.getConnection();
		callableStatement = connection.prepareCall(query);
		
		callableStatement.setString(1, username);
		callableStatement.setString(2, password);
		
		resultSet = callableStatement.executeQuery();

		if (resultSet.next()) {
			String getUsername = resultSet.getString("username");
			String getPassword = resultSet.getString("password");
			String getFullName = resultSet.getString("full_name");
			String getAddress = resultSet.getString("address");
			int getSalary = resultSet.getInt("salary");
			System.out.println(" Username: " + getUsername + " Password: " + getPassword + " Name: " + getFullName
					+ " Address: " + getAddress + " Salary: " + getSalary);
		} else {
			System.out.println("User Not Found");
		}
		
		ConnectionFactory.close(resultSet);
		ConnectionFactory.close(callableStatement);
		ConnectionFactory.close(connection);
	}

	// 3. UPDATE using CallableStatement with OUT parameter
	public void update(String username, int salary) throws SQLException {
		System.out.println("Update Method Called");
		String query = "{call sp_update_employee_salary(?, ?, ?)}";

		connection = ConnectionFactory.getConnection();
		callableStatement = connection.prepareCall(query);
		
		callableStatement.setString(1, username);
		callableStatement.setInt(2, salary);
		callableStatement.registerOutParameter(3, Types.INTEGER);

		callableStatement.execute();
		int rowsAffected = callableStatement.getInt(3);
		
		if (rowsAffected == 1) {
			System.out.println("Salary Updated ");
		} else {
			System.out.println("User Not Found And Salary Not Updated");
		}
		
		ConnectionFactory.close(callableStatement);
		ConnectionFactory.close(connection);
	}

	// 4. DELETE using CallableStatement with OUT parameter
	public void delete(String username) throws SQLException {
		System.out.println("Delete Method Called");
		String query = "{call sp_delete_employee(?, ?)}";

		connection = ConnectionFactory.getConnection();
		callableStatement = connection.prepareCall(query);
		
		callableStatement.setString(1, username);
		callableStatement.registerOutParameter(2, Types.INTEGER);

		callableStatement.execute();
		int rowsAffected = callableStatement.getInt(2);
		
		if (rowsAffected > 0) {
			System.out.println("User Deleted");
		} else {
			System.out.println("User Not Found");
		}
		
		ConnectionFactory.close(callableStatement);
		ConnectionFactory.close(connection);
	}

	// 5. DISPLAY ALL using CallableStatement
	public void displayAll() throws SQLException {
		System.out.println("Display All Data Method Called");
		String query = "{call sp_display_all_employees()}";

		connection = ConnectionFactory.getConnection();
		callableStatement = connection.prepareCall(query);

		resultSet = callableStatement.executeQuery();

		while (resultSet.next()) {
			String getUsername = resultSet.getString("username");
			String getPassword = resultSet.getString("password");
			String getFullName = resultSet.getString("full_name");
			String getAddress = resultSet.getString("address");
			int getSalary = resultSet.getInt("salary");
			System.out.println(" Username: " + getUsername + " Password: " + getPassword + " Name: " + getFullName
					+ " Address: " + getAddress + " Salary: " + getSalary);
		}
		
		ConnectionFactory.close(resultSet);
		ConnectionFactory.close(callableStatement);
		ConnectionFactory.close(connection);
	}
}