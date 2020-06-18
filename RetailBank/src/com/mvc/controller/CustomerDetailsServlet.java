package com.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.CustomerBean;
import com.mvc.util.DBConnection;

/**
 * Servlet implementation class CustomerDetailsServlet
 */
@WebServlet("/CustomerDetailsServlet")
public class CustomerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDetailsServlet() {
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
		System.out.println("servlet inside");
		
		 Connection con ;
	     PreparedStatement preparedStatement = null; 
	     ResultSet rs=null;
	     ArrayList<CustomerBean> custbean=new ArrayList<CustomerBean>();
	     //HttpSession session=request.getSession(false);
	     
	     try {
				con = DBConnection.createConnection();
					String query = "select * from customer";
preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				  
				     rs = preparedStatement.executeQuery();
				     
				     while(rs.next())
				     {
				    	 custbean.add(new CustomerBean(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
				    	 
				     }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	     //session.setAttribute("customerdetails", custbean);
	    RequestDispatcher rd= request.getRequestDispatcher("/customerdetails.jsp");
	    request.setAttribute("customerdetails", custbean); 
	    rd.forward(request, response);
	    
	     
	}

}
