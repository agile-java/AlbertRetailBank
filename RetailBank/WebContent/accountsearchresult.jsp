<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.mvc.bean.Account" %>
    <%@ page import="javax.servlet.*"%>  
    <%@ page import="javax.servlet.http.*"%>

    <% Account acc=(Account)request.getAttribute("acbean1");
    session.setAttribute("Account", acc);
    %>
    
    <%if(acc!=null){ %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search result</title>
</head>
<body>

<h2>ACCOUNT SEARCH RESULTS</h2>

<form>
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
<td><input type="button" value="home" onclick="location.href='accountsearch.jsp';"/></td>
<td><input type="button" value="delete" onclick="location.href='deleteaccount.jsp';"/></td>
</tr>

</table>
</form>
</body>
</html>
<%}else{%>
<%
response.sendRedirect("accountsearch.jsp");
}%>