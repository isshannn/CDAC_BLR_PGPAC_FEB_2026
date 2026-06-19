<%@ page import="java.util.*,com.library.model.Book"%>

<html>
<body>

<h2>All Books</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Author</th>
<th>Price</th>
</tr>

<%
List<Book> books =
(List<Book>)request.getAttribute("books");

for(Book b : books){
%>

<tr>

<td><%= b.getBid() %></td>
<td><%= b.getBname() %></td>
<td><%= b.getAuthor() %></td>
<td><%= b.getPrice() %></td>

</tr>

<%
}
%>

</table>

</body>
</html>