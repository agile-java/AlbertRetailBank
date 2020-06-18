package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.AccountStatementBean;
import com.mvc.dao.AccountStatementDao;

/**
 * Servlet implementation class Account Statement
 */
@WebServlet("/ServletAccountStatement")
public class AccountStatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountStatementServlet() {
        super();       
    }
          
    // This method will be invoked soon after this class is being invoked by Servlet
    // The request should contain parameter accountId
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	
    	System.out.println("inside do-Get Account Statement Servlet");    	
    	
     	String accountId = request.getParameter("accountId"); 
     	
     	AccountStatementBean objAccountStatementBean = new AccountStatementBean();
     	objAccountStatementBean.setAccountId(accountId);
     	
     	System.out.println("accountId"+objAccountStatementBean.getAccountId());
   
     	request.setAttribute("objAccountStatementBean", objAccountStatementBean);
        		         
		request.getRequestDispatcher("/CashierAccountStatement.jsp").forward(request, response);		
    }
    
 
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("inside doPost- Account Statement Servlet");
	  
	  	String accountId = request.getParameter("accountId");
	   	String startDate = request.getParameter("startDate");
	   	String endDate = request.getParameter("endDate");   	
	   	
	   	int noOfTransactions = 100;
	   	
	   	System.out.println("accountId"+accountId);
      
   		AccountStatementBean objAccountStatementBean=new AccountStatementBean();
   		objAccountStatementBean.setAccountId(accountId);
   		objAccountStatementBean.setStartDate(startDate);
   		objAccountStatementBean.setEndDate(endDate);
   		objAccountStatementBean.setNoOfTransactions(noOfTransactions);
   		
   		AccountStatementDao objAccountStatementDao=new AccountStatementDao();
   		ArrayList<AccountStatementBean> array1 = new ArrayList<AccountStatementBean>();   		
   		array1=objAccountStatementDao.getAccountStatementPageDetails(objAccountStatementBean);
  
   		System.out.println(array1.get(0).getDescription());
   		System.out.println(array1.get(0).getTransactionId());
   		System.out.println(array1.get(0).getAmount());
   		System.out.println(array1.get(0).getTransactionDate());
   		System.out.println(array1.size());
   	
   		request.setAttribute("array1", array1);
   		
		// check whether the object contains values
   		request.getRequestDispatcher("/CashierAccountStatementResults.jsp").forward(request, response);
    		
    }

}
