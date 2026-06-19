package com.ved.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	private PreparedStatement preparedStatement=null;

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
		String q = "insert into employee(username,password,full_name,address,salary) values(?,?,?,?,?)";

		Connection connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(q);

		preparedStatement.setString(1, employeedto.getUsername());
		preparedStatement.setString(2, employeedto.getPassword());
		preparedStatement.setString(3, employeedto.getFullname());
		preparedStatement.setString(4, employeedto.getAddress());
		preparedStatement.setInt(5,employeedto.getSalary());
		
		
		int executeUpdate = preparedStatement.executeUpdate();
		System.out.println(executeUpdate + ": Row Inserted!");

		ConnectionFactory.close(preparedStatement);
		ConnectionFactory.close(connection);
	}

	public void read(String username, String password) throws SQLException {
		System.out.println("Read Method Called");
		q = "select * from employee where username =? and password =?;";

		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(q);
		
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		
		resultSet = preparedStatement.executeQuery();

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
		ConnectionFactory.close(preparedStatement);

	}

	public void update(String username, int salary) throws SQLException {

		System.out.println("Update Method Called");

		q = "update employee set salary=? where username = ?";

		connection = ConnectionFactory.getConnection();
		preparedStatement=connection.prepareStatement(q);
		
		preparedStatement.setInt(1, salary);
		preparedStatement.setString(2, username);

		int executeUpdate = preparedStatement.executeUpdate();
		if (executeUpdate == 1) {
			System.out.println("Salary Updated ");
		} else {
			System.out.println("User Not Found And Salary Not Updated");
		}
		ConnectionFactory.close(statement);
		ConnectionFactory.close(preparedStatement);
		ConnectionFactory.close(connection);
	}

	public void delete(String username) throws SQLException {

		System.out.println("Delete Method Called");

		q = "delete from employee where username = ?";

		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(q);
		
		preparedStatement.setString(1, username);

		int executeUpdate = preparedStatement.executeUpdate();
		
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