package com.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class CustomerDeleteServlet
 */
@WebServlet("/CustomerDeleteServlet")
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDeleteServlet() {
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

		
        
        Connection con ;
	     PreparedStatement preparedStatement = null; 
	     //ResultSet rs=null;
        
        con = DBConnection.createConnection();
		String query = "delete from customer where customer_id=?";
		int i=0;
		 try {
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			 
			
			 preparedStatement.setInt(1, cust.getCustomerid());
			  i = preparedStatement.executeUpdate();
			  //session.invalidate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		 
		 if(i!=0) {
			 request.getRequestDispatcher("/deleteSuccess.jsp").forward(request, response);
		 }
		 else
		 {
			 request.getRequestDispatcher("/home.jsp").forward(request, response);
		 }
	}

}
