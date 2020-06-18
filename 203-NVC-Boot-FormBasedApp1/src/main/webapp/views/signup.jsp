<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="register" method="POST">
			<table>
				<tr>
					<th colspan="2">User Signup Page</th>
				</tr>
				<tr>
					<th>Username :</th>
					<th><input type="text" name="uname" /></th>
				</tr>
				<tr>
					<th>Password :</th>
					<th><input type="password" name="pwd" /></th>
				</tr>
				<tr>
					<th>Email-ID:</th>
					<th><input type="text" name="email" /></th>
				</tr>
				<tr>
					<th>Phone Number :</th>
					<th><input type="text" name="phone" /></th>
				</tr>
				<tr>
					<th><input type="submit" value=" Register " /></th>
					<th><input type="reset" value=" Re-enter " /></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>