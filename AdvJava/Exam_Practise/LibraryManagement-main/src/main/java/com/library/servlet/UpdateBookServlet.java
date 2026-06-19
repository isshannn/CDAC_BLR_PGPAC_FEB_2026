package com.library.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.library.dao.BookDAO;
import com.library.model.Book;

public class UpdateBookServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int bid =
                Integer.parseInt(request.getParameter("bid"));

        String bname =
                request.getParameter("bname");

        String author =
                request.getParameter("author");

        double price =
                Double.parseDouble(request.getParameter("price"));

        Book b =
                new Book(bid, bname, author, price);

        BookDAO dao =
                new BookDAO();

        dao.updateBook(b);

        response.getWriter().println("Book Updated Successfully");
    }
}