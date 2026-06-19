package com.ved;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewStudentServlet
 */
@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			HttpSession session = request.getSession(false);

			if (session == null) {
				response.sendRedirect("login.html");
				return;
			}

			StudentDAO dao = new StudentDAO();

			ArrayList<Student> list = dao.getStudents();

			request.setAttribute("slist", list);

			RequestDispatcher rd = request.getRequestDispatcher("view.jsp");

			rd.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	

}
