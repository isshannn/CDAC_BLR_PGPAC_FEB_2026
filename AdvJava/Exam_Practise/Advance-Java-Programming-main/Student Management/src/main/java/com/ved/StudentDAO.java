package com.ved;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO {
	Connection con;

	public StudentDAO() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/veddb", "root", "password");
	}

	public int addStudent(Student s) throws Exception {
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?)");

		ps.setInt(1, s.getSid());
		ps.setString(2, s.getSname());
		ps.setString(3, s.getCourse());

		return ps.executeUpdate();
	}

	public ArrayList<Student> getStudents() throws Exception {
		ArrayList<Student> list = new ArrayList<>();

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select * from student");

		while (rs.next()) {
			Student s = new Student();

			s.setSid(rs.getInt(1));
			s.setSname(rs.getString(2));
			s.setCourse(rs.getString(3));

			list.add(s);
		}

		return list;
	}
}
