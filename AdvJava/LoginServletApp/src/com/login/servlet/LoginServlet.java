package com.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter("userName");
		String pass = request.getParameter("passWord");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(user.equals("admin") && pass.equals("admin123")) {
			out.println("<html><body>");
			out.println("<h1> Authentication Success");
			out.println("</body></html>");
		}
		else {
			out.println("<html><body>");
			out.println("<h1> Authentication Failed");
			out.println("</body></html>");
		}
	}

}
