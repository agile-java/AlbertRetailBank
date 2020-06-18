<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

body {
font-size: 15px;
font-family: "Times New Roman", Times, seri
}


.tableHead {
 text-align: center
}

.table {
  margin: auto;
  padding: 10px;
 }
  
.table tr {
 line-height: 25px; 
 }
 
#transferAmountPara {
  text-align: center;
}

#submission {
  text-align: center;
 }

</style>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Money</title>
</head>
<body>

 <%@ page import="com.mvc.bean.TransferMoneyBean,com.mvc.dao.TransferMoneyDao,
 javax.xml.parsers.*,javax.xml.transform.*, 
 javax.xml.transform.dom.*,
 javax.xml.transform.stream.*,
 javax.xml.*,org.w3c.dom.*"
 %>
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
 


    <form method="POST" action="${pageContext.request.contextPath}/ServletTransferMoney">  
<h2 class="tableHead" >Transfer Money</h2>
<table class="table">

 <tr>
 	<td>
 		<label for="sourceCustomerId">Customer ID </label></td> 
 	<td>	
<input type="number" id="sourceCustomerId" name="sourceCustomerId" value="${objTransferMoneyBean.getSourceCustomerId()}" disabled> 
	</td> 	
</tr>

<tr>
 	<td>
 		<label for="sourceAccountId">Source Account Id</label>

 	<td>	
 	
  		<input type="number" id="sourceAccountId" name="sourceAccountId" value="${objTransferMoneyBean.getSourceAccountId()}" disabled> 
	</td> 	
</tr>

<tr>
 	<td>
 		<label for="targetAccountId">Target Account Id</label>

 	<td>	
 		
  <input type="number" id="targetAccountId" name="targetAccountId" >
	</td> 	
</tr>

/*<tr>
	<td>
		<label for="transferMoney">Transfer Amount  </label>
	</td>
	<td>
		<input type="number" id="transferMoney" name="transferMoney" placeholder="Enter Amount" step="0.01" min="100" max="100000">
	</td>
</tr>
</table>

<input type="hidden" name="sourceAccountId" value="${objTransferMoneyBean.getSourceAccountId()}"/>
<input type="hidden" name="targetAccountId" value="${objTransferMoneyBean.getTargetAccountId()}"/>
<input type="hidden" name="sourceCustomerId" value="${objTransferMoneyBean.getSourceCustomerId()}"/> 
<input type="hidden" name="transferMoney" value="${objTransferMoneyBean.getTransferMoney()}"/>

<p id="submission">
<input type="submit" value="Submit">
</p>



 </form>
</body>
</html>