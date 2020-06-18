package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mvc.bean.cashierBean;
import com.mvc.util.DBConnection;

public class cashierloginDao {

	public Boolean loginuser(cashierBean loginBean)
	{
	
     String username = loginBean.getUsername();
     String password = loginBean.getPassword();
     
     Connection con ;
     PreparedStatement preparedStatement = null; 
     
     try
     {
         con = DBConnection.createConnection();
         
         String query = "select * from cashier where username=? and password=?"; //Insert user details into the table 'USERS'
         preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
         
         preparedStatement.setString(1, username);
         preparedStatement.setString(2, password);
         
        ResultSet rs = preparedStatement.executeQuery();
         
          //Just to ensure data has been inserted into the database
        
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

}
