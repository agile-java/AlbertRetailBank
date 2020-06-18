package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.mvc.bean.DepositMoneyBean;
import com.mvc.bean.TransactionBean;
import com.mvc.util.DBConnection;

public class TransactionDao {

	public boolean createTransactionTable(TransactionBean objTransactionBean){
		
		
		String accountId = objTransactionBean.getAccountId();
		String customerId= objTransactionBean.getCustomerId();
		String transactionType= objTransactionBean.getTransactionType();
		double amount= objTransactionBean.getAmount();
		
		
		LocalDateTime myDateObj = LocalDateTime.now();  
	    System.out.println("Before formatting: " + myDateObj);  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	    
	    String dateTime = myDateObj.format(myFormatObj);    
	    System.out.println("After formatting: " + dateTime); 
	
	    Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hhmmssSSS");
        String transactionId = ft.format(dNow);
	    

	     boolean dBInsertStatus=false;     
	     
	     Connection con ;
	     PreparedStatement preparedStatement = null; 
	     
	     try
	     {
	         con = DBConnection.createConnection();	 
	         String query = "INSERT INTO retailbank.transaction VALUES (?,?,?,?,?,?);";

	         preparedStatement = con.prepareStatement(query);    
	         preparedStatement.setString(1,transactionId); 
	         preparedStatement.setString(2,accountId);  
	         preparedStatement.setString(3,customerId); 
	         preparedStatement.setString(4,transactionType); 
	         preparedStatement.setDouble(5,amount); 
	         preparedStatement.setString(6,dateTime); 
	         
	
	         preparedStatement.executeUpdate();
	         dBInsertStatus= true ;
	         
	         
	     }
	         
	     catch(SQLException e)
	     {
	        e.printStackTrace();
	        System.out.println(e);
	     }
	     
	     return dBInsertStatus;
	}
	
	

}
