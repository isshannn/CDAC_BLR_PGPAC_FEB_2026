package com.ved.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ved.DTO.EmployeeDTO;

public class Crud {
	private Connection connection;
	private String q;
	private Statement statement;

	private int salary;
	private String username;
	private String password;
	private String fullname;
	private String address;
	private ResultSet resultSet;

	public Crud() {

	}

	public void createTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			q = "CREATE TABLE IF NOT EXISTS employee (" + "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "username VARCHAR(30) NOT NULL UNIQUE," + "password VARCHAR(30)," + "full_name VARCHAR(100),"
					+ "address VARCHAR(200)," + "salary INT" + ")";
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

	public void insert(EmployeeDTO employeedto) throws SQLException {
		System.out.println("Insert Method Called!");
		String q = "INSERT INTO employee(username,password,full_name,address,salary) " + "VALUES('"
				+ employeedto.getUsername() + "','" + employeedto.getPassword() + "','" + employeedto.getFullname()
				+ "','" + employeedto.getAddress() + "'," + employeedto.getSalary() + ")";

		Connection connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();

		int executeUpdate = statement.executeUpdate(q);

		System.out.println(executeUpdate + ": Row Inserted!");

		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);
	}

	public void read(String username, String password) throws SQLException {
		System.out.println("Read Method Called");
		q = "select * from employee where username ='" + username + "' and password ='" + password + "';";

		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();

		resultSet = statement.executeQuery(q);

		if (resultSet.next()) {

			String getUsername = resultSet.getString("username");
			String getPassword = resultSet.getString("password");
			String getFullName = resultSet.getString("full_name");
			String getAddress = resultSet.getString("address");
			int getSalary = resultSet.getInt("salary");
			System.out.println(" Username: " + getUsername + " Password: " + getPassword + " Name: " + getFullName
					+ " Addreass: " + getAddress + " Salary: " + getSalary);

		} else {
			System.out.println("User Not Found");
		}
		ConnectionFactory.close(resultSet);
		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);

	}

	public void update(String username, int salary) throws SQLException {

		System.out.println("Update Method Called");

		q = "update employee set salary=" + salary + " where username = '" + username + "'";

		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();

		int executeUpdate = statement.executeUpdate(q);
		if (executeUpdate == 1) {
			System.out.println("Salary Updated ");
		} else {
			System.out.println("User Not Found And Salary Not Updated");
		}
		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);
	}

	public void delete(String username) throws SQLException {

		System.out.println("Delete Method Called");

		q = "delete from employee where username = '" + username + "'";

		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();

		int executeUpdate = statement.executeUpdate(q);
		if (executeUpdate > 0) {
			System.out.println("User Deleted");
		} else {
			System.out.println("User Not Found");
		}
		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);

	}

	public void displayAll() throws SQLException {
		System.out.println("Display All Data Method Called");
		q = "select * from employee ";

		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();

		resultSet = statement.executeQuery(q);

		while (resultSet.next()) {
			String getUsername = resultSet.getString("username");
			String getPassword = resultSet.getString("password");
			String getFullName = resultSet.getString("full_name");
			String getAddress = resultSet.getString("address");
			int getSalary = resultSet.getInt("salary");
			System.out.println(" Username: " + getUsername + " Password: " + getPassword + " Name: " + getFullName
					+ " Addreass: " + getAddress + " Salary: " + getSalary);
		}
		ConnectionFactory.close(resultSet);
		ConnectionFactory.close(statement);
		ConnectionFactory.close(connection);

	}

}