<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>CREATE ACCOUNT</h2>

<form action="AccountCreate" method="post">
<table>

<tr>
<td>Customer id</td>
<td>:<input type="text" name="customerid" /></td>
</tr>

<tr>
<tr><td>
<label for="actype">Account Type:</label></td>
 <td> <select name="actype" id="actype">
    <option value="current">current</option>
    <option value="savings">savings</option>
  </select></td></tr>>

<tr>
<td>Deposit amount</td>
<td>:<input type="text" name="deposit" /></td>
</tr>

<tr>

<td>:<input type="submit" name="create" /></td>
<td>:<input type="button" name="home" /></td>
</tr>
</table>
</form>

</body>
</html>