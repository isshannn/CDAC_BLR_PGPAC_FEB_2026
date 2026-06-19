package com.cdac.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.dao.StudentDAO;
import com.cdac.model.Student;


@WebServlet("/add")
public class AddStudentServlet
extends HttpServlet
{
protected void doPost(
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

     Student s =
             new Student();

     s.setSid(
     Integer.parseInt(
     request.getParameter("sid")));

     s.setSname(
     request.getParameter("sname"));

     s.setCourse(
     request.getParameter("course"));

     StudentDAO dao =
             new StudentDAO();

     int n =
             dao.addStudent(s);
     
     if(n > 0)
     {
         response.getWriter().println(
         "Student Added Successfully<br><br>");

         response.getWriter().println(
         "<a href='addstudent.html'>Add Another Student</a><br>");

         response.getWriter().println(
         "<a href='view'>View Students</a>");
     }
 }
 catch(Exception ex)
 {
	 response.getWriter().println(ex);
     ex.printStackTrace();
 }
}
}
