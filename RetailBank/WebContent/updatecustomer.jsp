<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.mvc.bean.CustomerBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE CUSTOMER DETAILS</title>
</head>
<body>
<% CustomerBean cust=(CustomerBean)session.getAttribute("customer");

%>
<h2>UPDATE CUSTOMER DETAILS</h2>

<form action="CustomerUpdateServlet" method="post">
<table>

<tr>
<td>Customer Id</td>
<td>:<%out.print(cust.getCustomerid()); %></td>
</tr>

<tr>
<td>Customer SSN Id</td>
<td>:<%out.print(cust.getSsnid()); %></td>
</tr>

<tr>
<td>Old Customer Name</td>
<td>:<%out.print(cust.getCustomername()); %></td>
</tr>

<tr>
<td>New Customer Name</td>
<td>:<input type="text" name="newname"/></td>
</tr>

<tr>
<td>old Age</td>
<td>:<%out.print(cust.getAge()); %></td>
</tr>

<tr>
<td>New Age</td>
<td>:<input type="text" name="newage"/></td>
</tr>

<tr>
<td>Address</td>
<td>:<%out.print(cust.getAddress()); %></td>
</tr>

<tr>
<td>New Address</td>
<td>:<input type="text" name="newaddress"/></td>
</tr>

<tr>
<td><input type="submit" value="update"/></td>
<td><input type="button" value="home" /></td>
</tr>

</table>
</form>
</body>
</html>