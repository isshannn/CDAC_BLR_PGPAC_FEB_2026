package com.cdac.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.dao.StudentDAO;
import com.cdac.model.Student;


@WebServlet("/view")
public class ViewStudentServlet
extends HttpServlet
{
protected void doGet(
     HttpServletRequest request,
     HttpServletResponse response)
     throws IOException
{
	
	response.setContentType("text/html");
 try
 {
     HttpSession session =
             request.getSession(false);

     if(session == null)
     {
         response.sendRedirect(
                 "login.html");
         return;
     }

     StudentDAO dao =
             new StudentDAO();

     ArrayList<Student> list =
             dao.getStudents();

     request.setAttribute(
             "slist", list);

     RequestDispatcher rd =
     request.getRequestDispatcher(
             "view.jsp");

     rd.forward(
             request,response);
     
 }
 catch(Exception ex)
 {
     ex.printStackTrace();
 }
}
}

