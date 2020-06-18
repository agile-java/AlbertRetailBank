<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.mvc.bean.CustomerBean" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search result</title>
</head>
<body>
<% ArrayList<CustomerBean> cust=(ArrayList<CustomerBean>)request.getAttribute("customerdetails");

%>
<h2>search result</h2>

<form>
<table border="1px">

<tr>
<th>Customer Id</th>
<th>SSN Id</th>
<th>name</th>
<th>age</th>
<th>address</th>
<th>city</th>
<th>state</th>
<th></th>
</tr>

<%for (int i=0; i<cust.size(); i++){ %>
              <tr> <td><%out.print(cust.get(i).getCustomerid()); %></td>
               <td><%out.print(cust.get(i).getSsnid()); %></td>
               <td><%out.print(cust.get(i).getCustomername()); %></td>
               <td><%out.print(cust.get(i).getAge()); %></td>
               <td><%out.print(cust.get(i).getAddress()); %></td>
               <td><%out.print(cust.get(i).getCity()); %></td>
               <td><%out.print(cust.get(i).getState()); %></td></tr>
           <%} %>

</table>
<h3><a href="home.jsp">back to home</a></h3>
</form>
</body>
</html>


