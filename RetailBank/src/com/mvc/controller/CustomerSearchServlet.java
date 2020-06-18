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

import com.mvc.bean.CustomerBean;
import com.mvc.util.DBConnection;

/**
 * Servlet implementation class CustomerSearchServlet
 */
@WebServlet("/CustomerSearchServlet")
public class CustomerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSearchServlet() {
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
		int ssnid=0,customerid=0;
		if(request.getParameter("customerid").equals(""))
				{
		 ssnid = Integer.parseInt(request.getParameter("ssnid"));
				}
		else
		{
		 customerid = Integer.parseInt(request.getParameter("customerid"));}
		
		 Connection con ;
	     PreparedStatement preparedStatement = null; 
	     ResultSet rs=null;
	     
		if(ssnid!=0)
		{
			  try {
				con = DBConnection.createConnection();
				String query = "select * from customer where ssn_id=?";
 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				 
				 preparedStatement.setInt(1, ssnid);
				
				 
				 rs = preparedStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			 try {
				con = DBConnection.createConnection();
					String query = "select * from customer where customer_id=?";
 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				     
				     preparedStatement.setInt(1, customerid);
				    
				     
				     rs = preparedStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		CustomerBean custbean=new CustomerBean();
		
		try {
			while(rs.next())
			{
				
				custbean.setCustomerid(rs.getInt(1));
				custbean.setSsnid(rs.getInt(2));
				custbean.setCustomername(rs.getString(3));
				custbean.setAge(rs.getInt(4));
				custbean.setAddress(rs.getString(5));
				custbean.setCity(rs.getString(6));
				custbean.setState(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		HttpSession session=request.getSession();
		if(custbean.getCustomerid()!=0) {
        	System.out.println("inside a condition");
        	
        	session.setAttribute("customer",custbean);
        	
        	//request.setAttribute("customer",custbean);
        	request.getRequestDispatcher("/customersearchresult.jsp").forward(request, response);
        	
        }
        else
        {
        	String error="invalid customer";
        	session.setAttribute("error",error);
        	request.getRequestDispatcher("/searchcustomer.jsp").forward(request, response);
        }
	           
	     
		}
	}


