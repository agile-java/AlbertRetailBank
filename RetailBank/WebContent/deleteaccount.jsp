<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.mvc.bean.Account" %>
    <%@ page import="javax.servlet.*"%>  
    <%@ page import="javax.servlet.http.*"%>

    <% Account acc=(Account)session.getAttribute("Account");
    //HttpSession session2=request.getSession();
    //session2.setAttribute("Account", acc);
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search result</title>
</head>
<body>

<h2>ACCOUNT dELETE SCREEN</h2>

<form action="AccountDeleteServlet" method="post">
<table>

<tr>
<td>Account Id</td>
<td>:<%out.print(acc.getAccountid()); %></td>
</tr>

<tr>
<td>Customer Id</td>
<td>:<%out.print(acc.getCustomerid()); %></td>
</tr>

<tr>
<td>Account Type</td>
<td>:<%out.print(acc.getAccounttype()); %></td>
</tr>

<tr>
<td>Balance</td>
<td>:<%out.print(acc.getBalance()); %></td>
</tr>



<tr>
<td><input type="submit" value="confirm" ;"/></td>
<td><input type="button" value="back" onclick="location.href='home.jsp';"/></td>
</tr>

</table>
</form>
</body>
</html>
