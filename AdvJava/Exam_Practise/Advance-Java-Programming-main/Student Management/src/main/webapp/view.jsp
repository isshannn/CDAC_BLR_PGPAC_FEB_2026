<%@page import="java.util.*"%>
<%@page import="com.ved.Student"%>

<html>
<body>

<h2>Student List</h2>

Welcome :
<%= session.getAttribute("username") %>

<br><br>

<table border="1">

<tr>
<th>SID</th>
<th>Name</th>
<th>Course</th>
</tr>

<%
ArrayList<Student> list =
(ArrayList<Student>)
request.getAttribute("slist");

for(Student s : list)
{
%>

<tr>
<td><%=s.getSid()%></td>
<td><%=s.getSname()%></td>
<td><%=s.getCourse()%></td>
</tr>

<%
}
%>

</table>

<br><br>

<a href="addstudent.html">Add Student</a>
&nbsp;&nbsp;
<a href="logout">Logout</a>

</body>
</html>
