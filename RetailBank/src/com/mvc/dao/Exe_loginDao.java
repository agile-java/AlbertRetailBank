package com.mvc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.mvc.bean.Exe_loginBean;
import com.mvc.bean.CustomerBean;
import com.mvc.util.DBConnection;

public class Exe_loginDao {
	public Boolean loginuser(Exe_loginBean loginBean)
	{
	
     String username = loginBean.getUserName();
     String password = loginBean.getPassword();
     
     Connection con ;
     PreparedStatement preparedStatement = null; 
     
     try
     {
         con = DBConnection.createConnection();
         
         String query = "select * from account_executive where username=? and password=?"; //Insert user details into the table 'USERS'
         preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
         
         preparedStatement.setString(1, username);
         preparedStatement.setString(2, password);
         
        ResultSet rs = preparedStatement.executeQuery();
         
          //Just to ensure data has been inserted into the database
        //System.out.println(rs.next());
         if( rs.next()==true)
         {
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
	public Boolean customercreate(CustomerBean custBean)
	{
	
     int ssnid = custBean.getSsnid();
     String name = custBean.getCustomername();
     int age = custBean.getAge();
     String address = custBean.getAddress();
     String state = custBean.getState();
     String city = custBean.getCity();
     
     Connection con ;
     PreparedStatement preparedStatement = null,ps2,ps3; 
     
     try
     {
         con = DBConnection.createConnection();
         
         String query = "insert into customer(ssn_id,name,age,address,city,state) values(?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
         preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
         
        
         
         preparedStatement.setInt(1,ssnid);
         preparedStatement.setString(2, name);
         preparedStatement.setInt(3, age);
         preparedStatement.setString(4, address);
         preparedStatement.setString(5,city);
         preparedStatement.setString(6,state);
         
        int i = preparedStatement.executeUpdate();
        
        String query1="select Customer_id from customer where ssn_id=?";
        ps2=con.prepareStatement(query1);
        ps2.setInt(1,ssnid);
        
        ResultSet rs=ps2.executeQuery();
        int cust_id=0;
         while(rs.next())
         {
        	  cust_id=rs.getInt(1);
        	  
         }
          //Just to ensure data has been inserted into the database
         java.sql.Date date=new java.sql.Date(Calendar.getInstance().getTime().getTime());
         System.out.println(cust_id);
         System.out.println(date);
         
        
        
         if(i!=0)
         {

 			try {
 				int j=0;
 				   String status="active"; String
 				  message="user created successfully"; 
 				  String query2="insert into customer_status (ssn_id,customer_id,status,message,last_updated) values(?,?,?,?,?)";
 					ps3=con.prepareStatement(query2); 
 					ps3.setInt(1,ssnid);
 				  ps3.setInt(2,cust_id);
 				  ps3.setString(3, status);
 				  ps3.setString(4, message);
 				  ps3.setTimestamp(5, java.sql.Timestamp.from(java.time.Instant.now()));
 				  
 				   j=ps3.executeUpdate();
 				   System.out.println(j);
 				   
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 				System.out.println(e +"inside a status table insertion");
 			}
 			 
        	 
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
