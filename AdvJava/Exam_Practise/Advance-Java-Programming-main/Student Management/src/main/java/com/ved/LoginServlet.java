package com.ved;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname = request.getParameter("uname");

		String pwd = request.getParameter("pwd");

		if (uname.equals("admin") && pwd.equals("123")) {
			HttpSession session = request.getSession();

			session.setAttribute("username", uname);

			response.getWriter().println("<h2>Login Successful</h2>");

			response.getWriter().println("<a href='addstudent.html'>Add Student</a><br>");

			response.getWriter().println("<a href='view'>View Students</a><br>");

			response.getWriter().println("<a href='logout'>Logout</a>");
		} else {
			response.getWriter().println("Invalid Login");
		}
	}

}
