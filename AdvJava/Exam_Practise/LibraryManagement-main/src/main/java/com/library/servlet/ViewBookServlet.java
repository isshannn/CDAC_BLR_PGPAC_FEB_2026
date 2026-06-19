package com.library.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.library.dao.BookDAO;
import com.library.model.Book;

public class ViewBookServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        BookDAO dao =
                new BookDAO();

        List<Book> books =
                dao.getBooks();

        request.setAttribute("books", books);

        RequestDispatcher rd =
                request.getRequestDispatcher("viewBooks.jsp");

        rd.forward(request, response);
    }
}