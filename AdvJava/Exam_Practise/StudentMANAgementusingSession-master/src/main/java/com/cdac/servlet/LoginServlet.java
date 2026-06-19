package com.cdac.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException
    {
    	
    	   response.setContentType("text/html");
    	   
    	   
        String uname = request.getParameter("uname");

        String pwd = request.getParameter("pwd");

        if(uname.equals("admin")
                && pwd.equals("123"))
        {
            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "username", uname);

            response.getWriter().println(
            "<h2>Login Successful</h2>");

            response.getWriter().println(
            "<a href='addstudent.html'>Add Student</a><br>");

            response.getWriter().println(
            "<a href='view'>View Students</a><br>");

            response.getWriter().println(
            "<a href='logout'>Logout</a>");
        }
        else
        {
            response.getWriter().println(
                    "Invalid Login");
        }
    }
}
