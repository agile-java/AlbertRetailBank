package com.mvc.controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.Account;
import com.mvc.util.DBConnection;
import com.oracle.jrockit.jfr.RequestDelegate;
import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * Servlet implementation class AccountSearch
 */
@WebServlet("/AccountSearch")
public class AccountSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountSearch() {
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
		
		int accountid = Integer.parseInt(request.getParameter("accountid"));
		Connection con ;
	     PreparedStatement preparedStatement = null; 
	    
	     Account acbean1=new Account();
	     
	     try {
				con = DBConnection.createConnection();
				String query = "select * from account where account_id=?";
preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				 
				 preparedStatement.setInt(1,accountid);
				
				 
				ResultSet rs = preparedStatement.executeQuery();
				//System.out.println(rs.next()+" result set");
				 try {
					while(rs.next())
						{
							
							acbean1.setAccountid(rs.getInt(1));
							acbean1.setCustomerid(rs.getInt(2));
							acbean1.setAccounttype(rs.getString(3));
							acbean1.setBalance(rs.getDouble(4));
							acbean1.setCreatedate(rs.getString(5));
							
							System.out.println(rs.getInt(1));
							System.out.println(rs.getInt(2));
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	     //HttpSession session=request.getSession(false);
	     
	     if(acbean1.getAccountid()!=0)
	     {
	    	 System.out.println("inside codition");
	    	 //session.setAttribute("acbean1", acbean1);
	    	 RequestDispatcher rd=request.getRequestDispatcher("/accountsearchresult.jsp");
	    	 request.setAttribute("acbean1", acbean1);
	    	 rd.forward(request, response);
	     }
	     else
	     {
	    	 request.getRequestDispatcher("/accountsearchresult.jsp").forward(request, response);
	     }
	     
	}

}
