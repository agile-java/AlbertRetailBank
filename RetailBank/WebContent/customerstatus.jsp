<%@page import="com.mvc.bean.Customerstatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.mvc.bean.CustomerBean" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CUSTOMER STATUS</title>
</head>
<body>
<% ArrayList<Customerstatus> cust=(ArrayList<Customerstatus>)request.getAttribute("statusbean");

%>
<h2>search result</h2>

<form>
<table border="1px">

<tr>
<th>Customer Id</th>
<th>SSN Id</th>

<th>status</th>
<th>message</th>
<th>Last Update</th>

</tr>

<%for (int i=0; i<cust.size(); i++){ %>
              <tr> <td><%out.print(cust.get(i).getCustomerid()); %></td>
               <td><%out.print(cust.get(i).getSsnid()); %></td>
               <td><%out.print(cust.get(i).getStatus()); %></td>
               <td><%out.print(cust.get(i).getMessage()); %></td>
               <td><%out.print(cust.get(i).getLastdate()); %></td>
               </tr>
           <%} %>

</table>
<h3><a href="home.jsp">back to home</a></h3>
</form>
</body>
</html>


