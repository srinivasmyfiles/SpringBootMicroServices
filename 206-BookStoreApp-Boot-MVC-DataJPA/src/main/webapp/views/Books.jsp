<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
</head>
<style>
table, tr, th, td {
	boder: 2px; 
	border-collapse: separate;
	background-color: lightgreen;
	padding: 10px;
	text-align: center;
}
</style>

<body>
	<div align="center">

		<table border="2">
			<thead>
			<tr>
			<th colspan="3"> <h1 style="color: darkgreen"> All Available Books </h1> </th>
			</tr>
			<tr>
			<th colspan="3"> <h2><a href="/bookstore/newBookEntry"> Add New Book</a>  </h2> </th>
			</tr>
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th>Cost</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books }" var="books">
					<tr>
						<td>${books.bookName}</td>
						<td>${books.authorName}</td>
						<td>${books.bookPrice}</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>