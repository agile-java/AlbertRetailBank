package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.Account;
import com.mvc.bean.Exe_loginBean;
import com.mvc.util.DBConnection;

public class AccountDao {
	public Boolean createAccount(Account createBean)
	{
	
     int customerid  = createBean.getCustomerid();
     String actype = createBean.getAccounttype();
     double balance=createBean.getBalance();
     
     Connection con ;
     PreparedStatement preparedStatement = null,preparedStatement1,preparedStatement2; 
     
     try
     {
         con = DBConnection.createConnection();
         
         String query = "insert into account (customer_id,account_type,balance,create_date) values (?,?,?,?)"; //Insert user details into the table 'USERS'
         preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
         
         preparedStatement.setInt(1, customerid);
         preparedStatement.setString(2, actype);
         preparedStatement.setDouble(3, balance);
         preparedStatement.setTimestamp(4, java.sql.Timestamp.from(java.time.Instant.now()));
         
        int j = preparedStatement.executeUpdate();
        ResultSet rs1=null;
         
          //Just to ensure data has been inserted into the database
        //System.out.println(rs.next());
         if( j!=0)
         {
        	 try {
				con = DBConnection.createConnection();
				 
				 String query2="select account_id from account where account_type=? and customer_id=? ";
				 preparedStatement2=con.prepareStatement(query2);
				 preparedStatement2.setString(1, actype);
				 preparedStatement2.setInt(2,customerid);
				 rs1 = preparedStatement2.executeQuery();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
				
				
			
        	 int accountid=0;
        	 while(rs1.next())
        	 {
        		 accountid=rs1.getInt(1);
        		 System.out.println(rs1.getInt(1));
        	 }
             
				
				  String status="active"; String
				  message="customer already has account of specified type";
				  String query1 = "insert into account_status (customer_id,account_id,account_type,status,message,last_updated) values (?,?,?,?,?,?)";
				   //Insert user details into the table 'USERS' 
				  preparedStatement1 =con.prepareStatement(query1); //Making use of prepared statements here to
				  
				  
				  preparedStatement1.setInt(1, customerid); 
				  preparedStatement1.setInt(2,accountid);
				  preparedStatement1.setString(3, actype);
				  preparedStatement1.setString(4, status);
				  preparedStatement1.setString(5, message);
				  preparedStatement1.setTimestamp(6,java.sql.Timestamp.from(java.time.Instant.now()));
				  
				   int k = preparedStatement1.executeUpdate();
				   System.out.println("Succeccfull dude"+k);
				  
				 
        	 return true;
         }
         else {
        	 return false;
         }
     }
     catch(SQLException e)
     {
        e.printStackTrace();
        System.out.println(e);
     }       
     return false; 

}
}