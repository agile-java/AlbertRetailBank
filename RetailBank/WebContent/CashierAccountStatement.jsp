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
		position: fixed;
        bottom: 30%;
        right: 40%;
	 }
	  
	.table tr {
	 border-style:hidden;
	 }
	 

	#transferAmountPara {
	  text-align: center;
	}
	
	#submission {
	  text-align: center;
	 }
</style>
<script type="text/javascript">
function ShowDiv(x){
	if (x ="yes"){
		document.getElementById("trHere").style.visibility="collapse";
		
	}
	if (x ="no"){
		document.getElementById("trHere").style.visibility="visible";
		
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Statement</title>
</head>
<body>

 <%@ page import="com.mvc.bean.DepositMoneyBean,com.mvc.dao.DepositMoneyDao,
 javax.xml.parsers.*,javax.xml.transform.*, 
 javax.xml.transform.dom.*,
 javax.xml.transform.stream.*,
 javax.xml.*,org.w3c.dom.*"
 %>
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
    
 <%
 
String accountId ="600";

 %>
 <form method="POST" action="${pageContext.request.contextPath}/ServletAccountStatement">  

<h2 class="tableHead" >Account Statement</h2>
<table class="table">

 <tr>
 	<td>
 		<label for="accountId">Account ID </label>
 		<input type="text" id="accountId" name="accountId" value="${objAccountStatementBean.getAccountId()}" disabled> 
 	</td>
</tr>

<tr>
 	<td>
 	<!-- 
 		 <input type="radio" id="lastNoOfTransactions" name="noOfTransactions" value="lastNoOfTransactions" onclick="ShowDiv('no')">
 		 <label for="lastNoOfTransactions">Last Number of Transactions</label><br>
 		  -->
 		
 		 <input type="radio" id="startEndDates" name="noOfTransactions" value="startEndDates" onclick="ShowDiv('yes')">
 		 <label for="startEndDates">Start-End Dates</label><br>
	</td> 
</tr>

<!--  <tr>
 	<td>
 		<label for="noOfTransactions ">Number of Transactions</label>	
 		<select name="targetAccountType" id="targetAccountType"> 
		    <option value="4">4</option>
		    <option value="3">3</option>  
		    <option value="2">2</option>  
		    <option value="1">1</option>  
  		</select> 
	</td> 	
</tr>-->



 <tr id="trHere">
 	<td>
 		<label for="startDate">Start Date </label>
 		<input type="number" id="startDate" name="startDate" value=""> 
 	</td>
 	<td>
 		<label for="endDate">End Date </label>
 		<input type="number" id="endDate" name="endDate" value=""> 
 	</td>
</tr>

<tr>
	<td>
		<input type="submit" value="Submit">
	<td>
</tr>
</table>

<input type="hidden" name="accountId" value="${objAccountStatementBean.getAccountId()}"/>
<input type="hidden" name="startDate" value="${objAccountStatementBean.getStartDate()}"/>
<input type="hidden" name="endDate" value="${objAccountStatementBean.getEndDate()}"/>

 </form>



</body>
</html>