<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.mvc.bean.CustomerBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search result</title>
</head>
<body>
<% CustomerBean cust=(CustomerBean)session.getAttribute("customer");

%>
<h2>search result</h2>

<form action="CustomerDeleteServlet" method="post">
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
<td>Customer Name</td>
<td>:<%out.print(cust.getCustomername()); %></td>
</tr>

<tr>
<td>Age</td>
<td>:<%out.print(cust.getAge()); %></td>
</tr>

<tr>
<td>Address</td>
<td>:<%out.print(cust.getAddress()); %></td>
</tr>

<tr>
<td>City</td>
<td>:<%out.print(cust.getCity()); %></td>
</tr>

<tr>
<td>State</td>
<td>:<%out.print(cust.getState()); %></td>
</tr>

<tr>
<td><input type="submit" value="confirm"/></td>
<td><input type="button" value="cancel" onclick="location.href='home.jsp';"/></td>
</tr>

</table>
</form>
</body>
</html>