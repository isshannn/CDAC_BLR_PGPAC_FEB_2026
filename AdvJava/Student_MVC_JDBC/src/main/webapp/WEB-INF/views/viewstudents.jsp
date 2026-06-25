<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Student List</h2>

		<table border="1" cellpadding="5">

	    <tr>
	        <th>ID</th>
	        <th>Name</th>
	        <th>Course</th>
	    </tr>
	
	    <c:forEach var="student" items="${students}">
	
	        <tr>
	            <td>${student.id}</td>
	            <td>${student.name}</td>
	            <td>${student.course}</td>
	        </tr>
	
	    </c:forEach>
	
	</table>

<br>

<a href="register">Add New Student</a>
	
</body>
</html>