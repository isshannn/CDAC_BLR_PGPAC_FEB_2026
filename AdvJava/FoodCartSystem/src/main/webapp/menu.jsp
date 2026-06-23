<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.FoodCart.pojo.FoodItem" %>

<% 
	List<FoodItem> menu_items = (List<FoodItem>) request.getAttribute("menu");
	
	if (menu_items == null) {
    	menu_items = new java.util.ArrayList<FoodItem>();
	}

%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<th>Food_id</th>
				<th>Food_name</th>
				<th>Price</th>
			</tr>

			<%
				for(FoodItem menu_obj : menu_items) { 	
			%>

			<tr>
				<td>
					<!-- 
						 Standard scriptlet tags execute Java code behind the scenes but do not print the result to the HTML output. 
						 To output a value to the web page, you must use JSP Expression tags, which include an equals sign 
						 and you must drop the semicolon.
					 -->
					<%= menu_obj.getFood_id()%>
				</td>
				<td>
					<%= menu_obj.getFood_name()%>
				</td>
				<td>
					<%= menu_obj.getPrice()%>
				</td>
				<td><button>+</button> 0 <button>-</button></td>
				<td><% %></td>
			</tr>

			<% } %>
		</table>
	</body>
	</html>