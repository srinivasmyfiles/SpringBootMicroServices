<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	
	<div align="center">
		<form:form action="registerPage" modelAttribute="student"
			method="POST">
			<table border="10">
				<tr>
					<th colspan="2">Student Registration Form</th>
				</tr>
				<tr>
					<th>User Name :</th>
					<td><form:input path="uname" /></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><form:password path="pwd" /></td>
				</tr>
				<tr>
					<th>Email address :</th>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<th>Phone number :</th>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<th>Gender :</th>
					<td><form:radiobutton path="gender" value="Male"/>Male <form:radiobutton
							path="gender" value="Female"/>Female</td>
				</tr>
				<tr>
					<th>Course :</th>
					<td><form:select path="course">
							<form:option value=""> -select- </form:option>
							<form:option value=" Java "> Java </form:option>
							<form:option value=" dotNet "> dotNet </form:option>
							<form:option value=" CPP "> CPP </form:option>
							<form:option value=" DS "> DS </form:option>
						</form:select></td>
				</tr>
				<tr>
					<th>Suitable Timings :</th>
					<td><form:checkbox path="timings" value="Morning" /> Morning
						<form:checkbox path="timings" value="Noon" /> Afternoon <form:checkbox
							path="timings" value="Evening" /> Evening</td>
				</tr>
				<tr>
					<td><input type="reset" value="Reset" /></td>
					<td><input type="submit" value="Register" /></td>
				</tr>

			</table>
			<h2 style="color:green">${result }</h2>
		</form:form>
	</div>
</body>
</html>