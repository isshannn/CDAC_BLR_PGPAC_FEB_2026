package com.library.dao;

import java.sql.*;
import java.util.*;

import com.library.model.Book;

public class BookDAO {

    Connection con;

    public BookDAO() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarymanagement",
                    "root",
                    "9450390189");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADD BOOK
    public void addBook(Book b) {

        try {

            String query =
                    "insert into book values(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, b.getBid());
            ps.setString(2, b.getBname());
            ps.setString(3, b.getAuthor());
            ps.setDouble(4, b.getPrice());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW BOOKS
    public List<Book> getBooks() {

        List<Book> list =
                new ArrayList<>();

        try {

            String query =
                    "select * from book";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Book b =
                        new Book();

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

    // UPDATE BOOK
    public void updateBook(Book b) {

        try {

            String query =
                    "update book set bname=?, author=?, price=? where bid=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, b.getBname());
            ps.setString(2, b.getAuthor());
            ps.setDouble(3, b.getPrice());
            ps.setInt(4, b.getBid());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 // DELETE BOOK

    public void deleteBook(int bid) {

        try {

            String query =
                    "delete from book where bid=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, bid);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}