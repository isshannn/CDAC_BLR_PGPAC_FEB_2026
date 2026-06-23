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

/*
  	LoginServlet here takes the userInput from login.html and authorizes the login(with help Login DAO class). 
 */


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
//	DBInitializer class here perfoms necessary SQL operations for APP functionality. This is called by default when the login happens.
	@Override
	public void init() throws ServletException{
		DBInitializer.createDatabase();
	}


//  Since HTML "POSTs" the servlets "gets"
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		Fetches from HTML page
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
