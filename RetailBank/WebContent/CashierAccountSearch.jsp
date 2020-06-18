<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cashier Home Page</title>
</head>
<body>
<h1>Cashier Home</h1>

<h4>Search Account/Customer Details</h4>

<form action="AccountDetailsServlet" method="post">
	<table>
	
		<tr>
			<td>Enter SSN Id</td>
			<td><input type="text" name="ssnid" /></td>
		</tr>
		
		<tr>
			<td>Enter Customer Id</td>
			<td><input type="text" name="customerid" /></td>
		</tr>	

		<tr>		
			<td>Enter Account Id</td>
			<td><input type="text" name="accountId" /></td>
		</tr>
		
		<tr>
		<td><input type="submit"  name="search" value="search" /></td>		
		</tr>
		
	</table>
</form>
</body>
</html>