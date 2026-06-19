package com.FoodCart.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FoodCart.dao.LoginDAO;
import com.FoodCart.util.DBInitializer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException{
		DBInitializer.createDatabase();
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");

		LoginDAO l_dao = new LoginDAO();

		if(l_dao.validate(userName, passWord)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userName);
//			Redirect to Servlet here not menu.jsp 
			response.sendRedirect("MenuServlet");
		}
		else {
			response.getWriter().print("Invalid Credentials");
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doGet(request, response);
	}

}
