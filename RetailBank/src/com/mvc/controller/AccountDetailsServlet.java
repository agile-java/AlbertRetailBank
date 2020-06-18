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

import com.mvc.bean.CashierCustomerBean;
import com.mvc.util.DBConnection;

/**
 * Servlet implementation class CustomerSearchServlet
 */
@WebServlet("/AccountDetailsServlet")
public class AccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDetailsServlet() {
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
		
		String ssnid=request.getParameter("ssnid");
		String customerid=request.getParameter("customerid");
		String accountId=request.getParameter("accountId");
				
		 Connection con ;
	     PreparedStatement preparedStatement = null; 
	     ResultSet rs=null;
	     String query ="";
	     
			  try {
				con = DBConnection.createConnection();
				if(!(ssnid.equals(""))){
					query = "SELECT customer.ssn_id,customer.customer_id,account.account_id,customer.name,account.account_type,account.balance FROM retailbank.account INNER JOIN retailbank.customer ON retailbank.account.customer_id = retailbank.customer.customer_id where ssn_id=?";
					preparedStatement = con.prepareStatement(query); 				 
					preparedStatement.setString(1, ssnid);	
				}
				else if(!(customerid.equals(""))){
					query = "SELECT customer.ssn_id,customer.customer_id,account.account_id,customer.name,"
							+ "account.account_type,account.balance FROM retailbank.account "
							+ "INNER JOIN retailbank.customer ON retailbank.account.customer_id "
							+ "= retailbank.customer.customer_id where retailbank.customer.customer_id=?";
					preparedStatement = con.prepareStatement(query); 				 
					preparedStatement.setString(1, customerid);	
				}
				else if(!(accountId.equals(""))){
					query = "SELECT customer.ssn_id,customer.customer_id,account.account_id,customer.name,"
							+ "account.account_type,account.balance FROM retailbank.account "
							+ "INNER JOIN retailbank.customer ON retailbank.account.customer_id "
							+ "= retailbank.customer.customer_id where retailbank.account.account_id=?";
						preparedStatement = con.prepareStatement(query); 				 
						preparedStatement.setString(1, accountId);	
				}
								 
				rs = preparedStatement.executeQuery();
				
			   } 
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }

		
			  CashierCustomerBean objCashierCustomerBean=new CashierCustomerBean();
		
		try {
			while(rs.next()){
				
				objCashierCustomerBean.setCustomerId(rs.getString("customer_id"));
				objCashierCustomerBean.setCustomerName(rs.getString("name"));
				objCashierCustomerBean.setAccountId(rs.getString("account_id"));
				objCashierCustomerBean.setBalance(rs.getDouble("balance"));
				objCashierCustomerBean.setSsnId(rs.getString("ssn_id"));
				objCashierCustomerBean.setAccountType(rs.getString("account_type"));
				System.out.println(rs.getString("account_id"));
				} 			
			}	
			
		catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
		}
		HttpSession session=request.getSession();
		if(objCashierCustomerBean!=null) {
        	System.out.println("inside a condition");
        	
        	session.setAttribute("customer",objCashierCustomerBean);
        	
        	//request.setAttribute("customer",objCashierCustomerBean);
        	request.getRequestDispatcher("/CashierAccountDetails.jsp").forward(request, response);
        	
        }       
	           
	     
		}
	}


