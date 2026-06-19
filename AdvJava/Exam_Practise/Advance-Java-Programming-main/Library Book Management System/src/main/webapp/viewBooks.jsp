<%@page import="java.util.*"%>
<%@page import="com.ved.pojo.Book"%>

<%
List<Book> books = (List<Book>) request.getAttribute("books");
%>

<table border="1">

	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Author</th>
		<th>Price</th>
	</tr>

	<%
	for (Book b : books) {
	%>

	<tr>
		<td><%=b.getBid()%></td>
		<td><%=b.getBname()%></td>
		<td><%=b.getAuthor()%></td>
		<td><%=b.getPrice()%></td>
	</tr>

	<%
	}
	%>

</table>