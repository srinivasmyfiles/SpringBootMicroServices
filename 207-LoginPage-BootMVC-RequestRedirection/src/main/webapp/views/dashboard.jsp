<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<div align="center">
		<h1 style="color: darkgreen">Welcome ${msg },</h1>
		<br /> <br /> <br />
		<h2 style="color: orange;">${loginMsg }</h2>
		<br />
		<h3 style="color: red;">
			<a href="/account"> Logout </a>
		</h3>
	</div>
</body>
</html>