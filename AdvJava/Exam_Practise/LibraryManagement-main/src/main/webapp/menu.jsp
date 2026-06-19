<%
String user =
(String)session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.html");
}
%>

<html>
<body>

<h2>Library Menu</h2>

<form action="menu" method="post">

1 Add Book
<br>

2 View Books
<br>

3 Update Book
<br>

4 Delete Book
<br>

5 Logout

<br><br>

Enter Choice:
<input type="text" name="choice">

<br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>