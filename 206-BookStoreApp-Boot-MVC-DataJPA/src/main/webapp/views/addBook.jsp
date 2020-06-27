<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: lightgreen;
	padding: 10px;
	text-align: center;
}
</style>

<body>
	<div align="center">
	<h2 style="color:orange;"> ${result } </h2>
		<form:form action="newBookEntry" modelAttribute="book" method="POST">
			<table>
				<tr>
					<th colspan="2"><h2 style="color: green">Add book details</h2></th>
				</tr>
				<tr>
					<th>Book Title :</th>
					<th><form:input path="bookName" /></th>
				</tr>
				<tr>
					<th>Author Name :</th>
					<th><form:input path="authorName" /></th>
				</tr>
				<tr>
					<th>Book Cost :</th>
					<th><form:input path="bookPrice" /></th>
				</tr>
				<tr>
					<th><input type="reset" value=" Clear " /> </th>
					<th><input type="submit" value=" Add" /></th>
				</tr>
				<tr>
					<th colspan="2"><a href="/bookstore/viewAllBooks"><h3 style="text-align: center">View All
							Books </h3></a></th>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>