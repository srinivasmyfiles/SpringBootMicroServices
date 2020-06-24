<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success </title>
</head>
<body>
	<div align="center">
	<h2 style="color: green"> ${result } </h2>
		<table>
			<tr>
				<th>Name :</th>
				<th>${student.uname }</th>
			</tr>
			<tr>
				<th>Email :</th>
				<th>${student.email}</th>
			</tr>
			<tr>
				<th>Phone :</th>
				<th>${student.phone}</th>
			</tr>
			<tr>
				<th>Gender :</th>
				<th>${student.gender}</th>
			</tr>
			<tr>
				<th>Course :</th>
				<th>${student.course}</th>
			</tr>
			<tr>
				<th>Timings :</th>
				<th>${student.timings[0]}  ${student.timings[1]}  ${student.timings[2]}</th>
			</tr>
		</table>
		<h2><a href="/demo"> Registration page </a></h2>
	</div>
</body>
</html>