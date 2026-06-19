package com.library.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.library.dao.BookDAO;

public class DeleteBookServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int bid =
                Integer.parseInt(request.getParameter("bid"));

        BookDAO dao =
                new BookDAO();

        dao.deleteBook(bid);

        response.getWriter().println("Book Deleted Successfully");
    }
}