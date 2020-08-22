<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StockMarketApp</title>
</head>
<body>
	<div align="center">
		<form action="getTotalCost">
			<h2>${total }</h2>
			<table>
				<thead>
					<tr>
						<th colspan="2">Stock Price App</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>Company name :</th>
						<th><input type="text" name="companyName"></th>
					</tr>
					<tr>
						<th>Quantity :</th>
						<th><input type="text" name="quantity"></th>
					</tr>
					<tr>
						<th colspan="2"><input type="submit" value="Calculate"></th>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>