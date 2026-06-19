package com.library.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/librarymanagement",
                            "root",
                            "9450390189");

            PreparedStatement ps =
                    con.prepareStatement(
                            "select * from login where username=? and password=?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                HttpSession session =
                        request.getSession();

                session.setAttribute("user", username);

                response.sendRedirect("menu.jsp");

            } else {

                response.sendRedirect("error.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}