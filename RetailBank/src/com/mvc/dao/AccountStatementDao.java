package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mvc.bean.AccountStatementBean;
import com.mvc.util.DBConnection;

public class AccountStatementDao {

		public ArrayList<AccountStatementBean> getAccountStatementPageDetails(AccountStatementBean objAccountStatementBean){
		
			
		ArrayList<AccountStatementBean> array1 = new ArrayList<AccountStatementBean>();
		
		array1.clear();
			
		 System.out.println("Inside Function - getAccountStatementPageDetails");
	     String accountId =objAccountStatementBean.getAccountId();
	     String startDate =objAccountStatementBean.getStartDate();
	     int noOfTransactions = objAccountStatementBean.getNoOfTransactions();
	     startDate=startDate+" 00:00:00.0";
	     String endDate = objAccountStatementBean.getEndDate();
	     endDate=endDate+" 23:59:59.0";
	     
		System.out.println(accountId);
		System.out.println(noOfTransactions);
		
	     Connection con ;
	     PreparedStatement preparedStatement = null; 
	     
	     try
	     {
	         con = DBConnection.createConnection();
	         
	         String query = "SELECT * FROM retailbank.transaction "
		         		+ "WHERE transaction_date BETWEEN? AND "
		         		+ "? AND account_id=?; ";
	         System.out.println(accountId);
	         preparedStatement = con.prepareStatement(query);         
	         preparedStatement.setString(1,startDate ); 
	         preparedStatement.setString(2,endDate);  
	         preparedStatement.setString(3,accountId );  
	         
	         System.out.println(accountId);
	         
	         ResultSet rs = preparedStatement.executeQuery();
	    	 
	         int count=1;
	     
	         //STEP 5: Extract data from result set
	         while(rs.next()){
	        	 if((count<noOfTransactions)){
		        	 AccountStatementBean tmp = new AccountStatementBean();
		        	 
		            //Retrieve by column name        
		        	 String transactionId=rs.getString("transaction_Id");        	    	 
		        	 String description=rs.getString("transaction_type");
		        	 double amount = rs.getDouble("amount");	        	 
		        	 String transactionDate=rs.getString("transaction_date");
		        	 
		        	 
		        	 
		        	 tmp.setAccountId(accountId);		         
		        	 tmp.setDescription(description);
		        	 tmp.setAmount(amount);		         
		        	 tmp.setTransactionDate(transactionDate);
		        	 tmp.setTransactionId(transactionId);
	
			         
			         array1.add(tmp);
			         
			         System.out.println(tmp.getTransactionDate());
			         System.out.println(tmp.getDescription());
			         System.out.println(tmp.getTransactionId());
			         System.out.println(tmp.getAmount());
			         System.out.println(tmp.getAccountId());
			         tmp=null;
			         count = count+1;
		         }
	         }
	         
	         return array1; 
	         
	     }
	         
	     catch(SQLException e)
	     {
	        e.printStackTrace();
	        System.out.println(e);
	        return null;
	     }
	     
		
		}
}
	 
	     