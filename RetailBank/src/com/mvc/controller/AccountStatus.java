package com.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.AccountstatusBean;
import com.mvc.bean.Customerstatus;
import com.mvc.util.DBConnection;

/**
 * Servlet implementation class AccountStatus
 */
@WebServlet("/AccountStatus")
public class AccountStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountStatus() {
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
	     ArrayList<AccountstatusBean> accountstatus=new ArrayList<AccountstatusBean>();
	     HttpSession session=request.getSession(false);
	     
	     try {
				con = DBConnection.createConnection();
					String query = "select * from account_status";
preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				  
				     rs = preparedStatement.executeQuery();
				     
				     while(rs.next())
				     {
				    	 accountstatus.add(new AccountstatusBean(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7)));
				    	 
				     }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	     session.setAttribute("accountstatus", accountstatus);
	     request.getRequestDispatcher("/accountstatus.jsp").forward(request, response);
	}

}
