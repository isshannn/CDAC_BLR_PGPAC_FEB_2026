package com.ved.dao;

import java.sql.*;
import java.util.*;

import com.ved.pojo.Book;
import com.ved.util.DBConnection;

public class BookDAO {

	public int addBook(Book b) {

		int status = 0;

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("insert into book values(?,?,?,?)");

			ps.setInt(1, b.getBid());
			ps.setString(2, b.getBname());
			ps.setString(3, b.getAuthor());
			ps.setDouble(4, b.getPrice());

			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public List<Book> getAllBooks() {

		List<Book> list = new ArrayList<>();

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from book");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Book b = new Book();

				b.setBid(rs.getInt(1));
				b.setBname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));

				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int updateBook(Book b) {

		int status = 0;

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("update book set bname=?,author=?,price=? where bid=?");

			ps.setString(1, b.getBname());
			ps.setString(2, b.getAuthor());
			ps.setDouble(3, b.getPrice());
			ps.setInt(4, b.getBid());

			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
}