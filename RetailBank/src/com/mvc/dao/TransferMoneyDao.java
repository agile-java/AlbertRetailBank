package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.TransferMoneyBean;
import com.mvc.util.DBConnection;

public class TransferMoneyDao {

	public boolean setBalanceInAccountTable(TransferMoneyBean objTransferMoneyBean){
		
	     String sourceAccountId =objTransferMoneyBean.getSourceAccountId();
	     String transferAccountId =objTransferMoneyBean.getTargetAccountId();
	     double sourceAccountBalance =objTransferMoneyBean.getSourceAccountBalance();
	     double targetAccountBalance =objTransferMoneyBean.getTargetAccountBalance();
	     
	     boolean dBInsertStatus=false;
	     Connection con ;
	     PreparedStatement preparedStatement = null; 
	     
	     try
	     {
	         con = DBConnection.createConnection();	         
	         String query = "UPDATE retailbank.account SET balance=? WHERE account_id=?; ";
	         preparedStatement = con.prepareStatement(query);    
	         preparedStatement.setDouble(1,sourceAccountBalance); 
	         preparedStatement.setString(2,sourceAccountId);  
	     
	         preparedStatement.executeUpdate();
	         dBInsertStatus= true ;
	         
	         con = DBConnection.createConnection();	         
	         String query2 = "UPDATE retailbank.account SET balance=? WHERE account_id=?; ";
	         preparedStatement = con.prepareStatement(query2);    
	         preparedStatement.setDouble(1,targetAccountBalance); 
	         preparedStatement.setString(2,transferAccountId);  
	     
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
	
	public TransferMoneyBean getTransferPageDetails(TransferMoneyBean objTransferMoneyBean){
	
	     String sourceAccountId =objTransferMoneyBean.getSourceAccountId();
	     String targetAccountId =objTransferMoneyBean.getTargetAccountId();
	     double sourceAccountBalance = 0;
	     double targetAccountBalance = 0;
	     String sourceCustomerId ="NA";
	     String targetCustomerId ="222";
	    
	   

     Connection con ;
     PreparedStatement preparedStatement = null; 
     
     try
     {
         con = DBConnection.createConnection();
         
         String query = "Select * from retailbank.account where account_id= ?; ";
         preparedStatement = con.prepareStatement(query);         
         preparedStatement.setString(1,sourceAccountId );         
         ResultSet rs = preparedStatement.executeQuery();
    	 
     
         //STEP 5: Extract data from result set
         while(rs.next()){
            //Retrieve by column name        
        	sourceAccountBalance  = rs.getDouble("balance");  
        	sourceCustomerId  = rs.getString("customer_id");

         }
         
         
         
         query = "Select * from retailbank.account where account_id= ?; ";
         preparedStatement = con.prepareStatement(query);         
         preparedStatement.setString(1,targetAccountId );         
         rs = preparedStatement.executeQuery();
    	 
     
         //STEP 5: Extract data from result set
         while(rs.next()){
            //Retrieve by column name        
        	targetAccountBalance  = rs.getDouble("balance");  	
        	targetCustomerId  = rs.getString("customer_id");


         }
         
         objTransferMoneyBean.setSourceAccountBalance(sourceAccountBalance);
         objTransferMoneyBean.setTargetAccountBalance(targetAccountBalance);
         objTransferMoneyBean.setSourceCustomerId(sourceCustomerId);
         objTransferMoneyBean.setTargetCustomerId(targetCustomerId);
         
         
         return objTransferMoneyBean; 
         
     }
         
     catch(SQLException e)
     {
        e.printStackTrace();
        System.out.println(e);
        return null;
     }
     
	}
	
	
}
