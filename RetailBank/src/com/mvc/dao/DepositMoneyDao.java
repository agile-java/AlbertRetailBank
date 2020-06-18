package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.DepositMoneyBean;
import com.mvc.util.DBConnection;

public class DepositMoneyDao {

	public boolean setBalanceInAccountTable(DepositMoneyBean objDepositMoneyBean){
		
	     String accountId =objDepositMoneyBean.getAccountId();
	     double balance =objDepositMoneyBean.getBalance();
	     boolean dBInsertStatus=false;
	     Connection con ;
	     PreparedStatement preparedStatement = null; 
	     
	     try
	     {
	         con = DBConnection.createConnection();	         
	         String query = "UPDATE retailbank.account SET balance=? WHERE account_id=?; ";
	         preparedStatement = con.prepareStatement(query);    
	         preparedStatement.setDouble(1,balance); 
	         preparedStatement.setString(2,accountId);  
	         System.out.println(balance);
	         System.out.println(accountId);
	     
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
	
	public DepositMoneyBean getDepositPageDetails(DepositMoneyBean objDepositMoneyBean){
	
     String accountId =objDepositMoneyBean.getAccountId();
     double balance = 0;
     String accountType="NA";
     String customerId="";
     
     Connection con ;
     PreparedStatement preparedStatement = null; 
     
     try
     {
         con = DBConnection.createConnection();
         
         String query = "Select * from retailbank.account where account_id= ?; ";
         preparedStatement = con.prepareStatement(query);         
         preparedStatement.setString(1,accountId );         
         ResultSet rs = preparedStatement.executeQuery();
    	 
     
         //STEP 5: Extract data from result set
         while(rs.next()){
            //Retrieve by column name        
            balance  = rs.getDouble("balance");  
            accountType=rs.getString("account_type");
            customerId=rs.getString("customer_Id");
         }
         
         objDepositMoneyBean.setBalance(balance);
         objDepositMoneyBean.setAccountType(accountType);
         objDepositMoneyBean.setCustomerId(customerId);
         
         return objDepositMoneyBean; 
         
     }
         
     catch(SQLException e)
     {
        e.printStackTrace();
        System.out.println(e);
        return null;
     }
     
	}
	
	
	

}
