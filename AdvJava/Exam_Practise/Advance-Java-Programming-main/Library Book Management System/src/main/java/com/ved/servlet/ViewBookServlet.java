package com.ved.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.ved.dao.BookDAO;
import com.ved.pojo.Book;

@WebServlet("/ViewBookServlet")
public class ViewBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        BookDAO dao = new BookDAO();

        List<Book> books =
                dao.getAllBooks();

        request.setAttribute("books", books);

        RequestDispatcher rd =
                request.getRequestDispatcher("viewBooks.jsp");

        rd.forward(request, response);
    }
}