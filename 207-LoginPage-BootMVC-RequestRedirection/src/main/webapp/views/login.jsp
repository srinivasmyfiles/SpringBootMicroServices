<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>


<body>
	<div align="center" >
		<form action="/account/login" method="POST" >
		<h2 style="color: red"> ${msg } </h2>
			<table border="2">

				<tr>
					<th colspan="2">Please login</th>
				</tr>

				<tr>
					<th> User name :</th>
					<td><input type="text" name="uname" /></td>
				</tr>
				<tr>
					<th> Password : </th>
					<td> <input type="text" name="pwd"/>  </td>
				</tr>
				<tr>
					<th> <input type="reset" value="Reset"/>  </th>
					<td> <input type="submit" value="Login"/> </td>
				</tr>


			</table>

		</form>

	</div>



</body>
</html>