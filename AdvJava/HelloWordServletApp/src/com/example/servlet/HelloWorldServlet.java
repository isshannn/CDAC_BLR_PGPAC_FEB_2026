package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 1. Set the response content type to HTML
        response.setContentType("text/html");

        // 2. Get the PrintWriter object to write text to the client
        PrintWriter out = response.getWriter();

        // 3. Write the HTML output
        out.println("<html><body>");
        out.println("<h2>Hello, World! My Servlet is running.</h2>");
        out.println("</body></html>");
		
	}
}
