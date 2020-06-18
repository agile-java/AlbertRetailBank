<%@page import="com.mvc.bean.Customerstatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.mvc.bean.AccountstatusBean" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CUSTOMER STATUS</title>
</head>
<body>
<% ArrayList<AccountstatusBean> acc=(ArrayList<AccountstatusBean>)session.getAttribute("accountstatus");

%>
<h2>ACCOUNT STATUS DETAILS</h2>

<form>
<table border="1px">

<tr>
<th>Customer Id</th>
<th>Account Id</th>
<th>Account type</th>
<th>status</th>
<th>message</th>
<th>Last Update</th>

</tr>

<%for (int i=0; i<acc.size(); i++){ %>
              <tr> <td><%out.print(acc.get(i).getCustomerid()); %></td>
               <td><%out.print(acc.get(i).getAccount_id()); %></td>
               <td><%out.print(acc.get(i).getAccounttype()); %></td>
               <td><%out.print(acc.get(i).getStatus()); %></td>
               <td><%out.print(acc.get(i).getMessage()); %></td>
               <td><%out.print(acc.get(i).getLast_update()); %></td>
               </tr>
           <%} %>

</table>
<h3><a href="home.jsp">back to home</a></h3>
</form>
</body>
</html>


