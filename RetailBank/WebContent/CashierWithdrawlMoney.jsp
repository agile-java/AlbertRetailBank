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
 
#withdrawMoneyPara {
  text-align: center;
}

#submission {
  text-align: center;
 }

</style>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw Money</title>
</head>
<body>

 <%@ page import="com.mvc.bean.WithdrawlMoneyBean,com.mvc.dao.WithdrawlMoneyDao,
 javax.xml.parsers.*,javax.xml.transform.*, 
 javax.xml.transform.dom.*,
 javax.xml.transform.stream.*,
 javax.xml.*,org.w3c.dom.*"
 %>
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
 
 
 
 <form method="POST" action="${pageContext.request.contextPath}/ServletWithdrawlMoney">  
 
<h2 class="tableHead" >Withdrawl Money</h2>
<table class="table">
  <tr>
    <td>Customer ID</td>
     <td>:</td>
    <td>${objWithdrawlMoneyBean.getCustomerId()}</td>
  </tr>
  <tr>
    <td>Account ID</td>
     <td>:</td>
    <td>${objWithdrawlMoneyBean.getAccountId()}</td>
  </tr>
   <tr>
    <td>Account Type</td>
     <td>:</td>
    <td>${objWithdrawlMoneyBean.getAccountType()}</td>
  </tr>
   <tr>
    <td>Balance</td>
     <td>:</td>
     <td>${objWithdrawlMoneyBean.getBalance()}</td>
    
  </tr>
</table> 

<p id="withdrawlMoneyPara">
 <label for="withdrawlMoney">Withdrawl Money </label>
 <input type="number" id="withdrawlMoney" name="withdrawlMoney" placeholder="Enter Money" step="0.01" min="100" max="100000">
 </br>
 </br>
</p>

<p id="submission">
<input type="submit" value="Submit">
</p>
<input type="hidden" name="accountId" value="${objWithdrawlMoneyBean.getAccountId()}"/>
<input type="hidden" name="balance" value="${objWithdrawlMoneyBean.getBalance()}"/>
<input type="hidden" name="customerId" value="${objWithdrawlMoneyBean.getCustomerId()}"/>
 </form>

  
 
 
  
    
</body>
</html>