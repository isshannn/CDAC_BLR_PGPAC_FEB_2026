<%@ page language="java" %>

<%
if(session.getAttribute("user")==null)
{
    response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

<h2 style="background-color: #686B96; font-style: italic; color: white;">Welcome Librarian</h2>
<div >
<a href="addBook.jsp" >Add Book</a>
<br><br>

<a href="ViewBookServlet">View Books</a>
<br><br>
<a href="updateBook.jsp">Update Books</a>
<br><br>

<a href="LogoutServlet">Logout</a>

</div>
</body>
</html>