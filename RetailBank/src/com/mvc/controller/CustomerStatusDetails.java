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
import com.mvc.bean.Customerstatus;
import com.mvc.util.DBConnection;

/**
 * Servlet implementation class CustomerStatusDetails
 */
@WebServlet("/CustomerStatusDetails")
public class CustomerStatusDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerStatusDetails() {
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
		 Connection con ;
	     PreparedStatement preparedStatement = null; 
	     ResultSet rs=null;
	     ArrayList<Customerstatus> statusbean=new ArrayList<Customerstatus>();
	     //HttpSession session=request.getSession(false);
	     
	     try {
				con = DBConnection.createConnection();
					String query = "select * from customer_status";
preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				  
				     rs = preparedStatement.executeQuery();
				     
				     while(rs.next())
				     {
				    	 statusbean.add(new Customerstatus(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				    	 
				     }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	     //session.setAttribute("statusbean", statusbean);
	     RequestDispatcher rd= request.getRequestDispatcher("/customerstatus.jsp");
	     request.setAttribute("statusbean", statusbean);
	     rd.forward(request, response);
	}

}
