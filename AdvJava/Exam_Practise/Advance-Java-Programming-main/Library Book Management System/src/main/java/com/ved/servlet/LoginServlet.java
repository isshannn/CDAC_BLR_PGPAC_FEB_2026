package com.ved.servlet;

import java.io.IOException;
import com.ved.util.DatabaseInitializer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ved.dao.LoginDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	
	
	@Override
	public void init() throws ServletException {
	    DatabaseInitializer.createDatabase();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {

	    response.getWriter().println("LoginServlet Working");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");

		String password = request.getParameter("password");

		LoginDAO dao = new LoginDAO();

		if (dao.validate(username, password)) {

			HttpSession session = request.getSession();

			session.setAttribute("user", username);

			response.sendRedirect("home.jsp");

		} else {

			response.getWriter().println("Invalid Login");

		}
	}
}