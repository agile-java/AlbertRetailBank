<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Customer</title>
</head>
<body>
<form action="CashierCustomerSearchServlet" method="post">



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
<td><input type="submit"  name="search" value="search" /></td>

</tr>

</table>
</form>
</body>
</html>