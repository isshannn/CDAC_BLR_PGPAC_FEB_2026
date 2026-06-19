package com.library.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MenuServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int choice =
                Integer.parseInt(request.getParameter("choice"));

        switch(choice) {

            case 1:

                response.sendRedirect("addBook.jsp");
                break;

            case 2:

                response.sendRedirect("viewBooks");
                break;

            case 3:

                response.sendRedirect("updateBook.jsp");
                break;

            case 4:

                response.sendRedirect("deleteBook.jsp");
                break;

            case 5:

                response.sendRedirect("logout");
                break;

            default:

                response.getWriter().println("Invalid Choice");
        }
    }
}