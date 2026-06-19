package com.ved.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.ved.dao.BookDAO;
import com.ved.pojo.Book;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Book b = new Book();

		b.setBid(Integer.parseInt(request.getParameter("bid")));
		b.setBname(request.getParameter("bname"));
		b.setAuthor(request.getParameter("author"));
		b.setPrice(Double.parseDouble(request.getParameter("price")));

		BookDAO dao = new BookDAO();

		dao.addBook(b);

		response.sendRedirect("home.jsp");
	}
}