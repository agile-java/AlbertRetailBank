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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Statement Results</title>
</head>
<body>

 <%@ page import="com.mvc.bean.AccountStatementBean,com.mvc.dao.DepositMoneyDao,
 javax.xml.parsers.*,javax.xml.transform.*, 
 javax.xml.transform.dom.*,
 javax.xml.transform.stream.*,
 javax.xml.*,org.w3c.dom.*"
 %>
 
 <%@ page import="com.mvc.bean.AccountStatementBean" %>
    <%@ page import="java.util.ArrayList" %>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
    
 <%
 
 ArrayList<AccountStatementBean> array1=(ArrayList<AccountStatementBean>)request.getAttribute("array1");
 
 %>


<h2 class="tableHead" >Account Statement Results</h2>

<table class="table" >

	<tr>
	 	<td>
	 		<label for="accountId">Account ID </label>
	 		<input type="text" id="accountId" name="accountId" value="${array1.get(0).getAccountId()}" disabled> 
	 	</td>
	</tr>


	<tr>
	 	<td>
	 		 <input type="radio" id="lastNoOfTransactions" name="noOfTransactions" value="lastNoOfTransactions">
	 		 <label for="lastNoOfTransactions">Last Number of Transactions</label><br>
	 		 <input type="radio" id="startEndDates" name="noOfTransactions" value="startEndDates">
	 		 <label for="startEndDates">Start-End Dates</label><br>
		</td> 
	</tr>

	<tr>
	 	<td>
	 		<label for="noOfTransactions ">Number of Transactions</label>	
	 		<select name="targetAccountType" id="targetAccountType" disabled> 
			    <option value="4">4</option>
			    <option value="3">3</option>  
			    <option value="2">2</option>  
			    <option value="1">1</option>  
	  		</select> 
		</td> 	
	</tr>
	
	<tr>
 	<td>
 		<label for="startDate">Start Date </label>
 		<input type="number" id="startDate" name="startDate" value="" disabled> 
 	</td>
</tr>
 <tr>
 	<td>
 		<label for="endDate">End Date </label>
 		<input type="number" id="endDate" name="endDate" value="" disabled> 
 	</td>
</tr>
	
	<tr>
	</br></br></br></br>
	</tr>
	
	<tr>
		<td>
			<table border="1px">
				<tr>
					<th>AccountId Id</th>
					<th>TransactionId Id</th>
					<th>Amount type</th>
					<th>TransactionDate</th>				
				</tr>

				<%for (int i=0;i<array1.size();i++){ %>
					<tr> 
					<td><%out.print(array1.get(i).getAccountId()); %></td>
					<td><%out.print(array1.get(i).getTransactionId()); %></td>
					<td><%out.print(array1.get(i).getAmount()); %></td>
					<td><%out.print(array1.get(i).getTransactionDate()); %></td>
					</tr><%
				}
				 
				 %>
				 </tr>
			</table>
		</td>
	</tr>
</table>

</body>
</html>