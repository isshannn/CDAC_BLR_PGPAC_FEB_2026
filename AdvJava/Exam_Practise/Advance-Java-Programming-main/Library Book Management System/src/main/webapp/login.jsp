<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<h2 style="background-color: #686B96; font-style: italic; color: white;">Library Login</h2>

	<form action="LoginServlet" method="post" ">

		Username: <input type="text" name="username"> <br>
		<br> Password: <input type="password" name="password"> <br>
		<br> <input type="submit" value="Login">

	</form>

</body>
</html>