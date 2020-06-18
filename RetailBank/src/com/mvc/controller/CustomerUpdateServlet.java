package com.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.*;
import com.mvc.util.DBConnection;

/**
 * Servlet implementation class CustomeUpdateServlet
 */
@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		CustomerBean cust=(CustomerBean)session.getAttribute("customer");

		String newname = request.getParameter("newname");
        int newage =Integer.parseInt(request.getParameter("newage"));
        String newaddress = request.getParameter("newaddress");
        
        Connection con ;
	     PreparedStatement preparedStatement = null,ps1,ps3; 
	     //ResultSet rs=null;
        
        con = DBConnection.createConnection();
		String query = "update customer set name=? , age=? ,address=? where customer_id=?";
		int i=0;
		 try {
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			 
			 preparedStatement.setString(1, newname);
			 preparedStatement.setInt(2, newage);
			 preparedStatement.setString(3, newaddress);
			 preparedStatement.setInt(4, cust.getCustomerid());
			  i = preparedStatement.executeUpdate();
			  //session.invalidate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		 
		 if(i!=0) {
				try {
	 				int j=0;
	 				   String status="active"; 
	 				  String message="user updated succeccfully..!!"; 
	 				  String query2="update customer_status set Status=?,message=?,last_updated=? where customer_id=? ";
	 					ps3=con.prepareStatement(query2); 
	 					
	 				  
	 				  ps3.setString(1, status);
	 				  ps3.setString(2, message);
	 				  ps3.setTimestamp(3, java.sql.Timestamp.from(java.time.Instant.now()));
	 				  ps3.setInt(4,cust.getCustomerid());
	 				 //ps3.setString(5, message);
	 				  
	 				   try {
						j=ps3.executeUpdate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println(e);
					}
	 				   
	 				   
	 				   System.out.println(j+"value of j");
	 				   
	 			} catch (Exception e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 				System.out.println(e +"inside a status table insertion");}
	 			
			 request.getRequestDispatcher("/updatesuccessfull.jsp").forward(request, response);
		 }
		 else
		 {
			 request.getRequestDispatcher("/home.jsp").forward(request, response);
		 }
		 
	}

}
