package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.DepositMoneyBean;
import com.mvc.bean.TransactionBean;
import com.mvc.dao.DepositMoneyDao;
import com.mvc.dao.TransactionDao;

/**
 * Servlet implementation class Deposit Money
 */
@WebServlet("/ServletDepositMoney")
public class DepositMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DepositMoneyServlet() {
        super();       
    }
          
    // This method will be invoked soon after this class is being invoked by Servlet
    // The request should contain parameter accountId
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
     	String accountId = request.getParameter("accountId");
 
		DepositMoneyBean objDepositMoneyBean=new DepositMoneyBean();
		objDepositMoneyBean.setAccountId(accountId);
		DepositMoneyDao objDepositMoneyDao=new DepositMoneyDao();		
		objDepositMoneyBean=objDepositMoneyDao.getDepositPageDetails(objDepositMoneyBean);
		
		request.setAttribute("objDepositMoneyBean", objDepositMoneyBean);		         
		request.getRequestDispatcher("/CashierDepositMoney.jsp").forward(request, response);		
    }
 
    // This method will be invoked when the Submit button is clicked
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String accountId = request.getParameter("accountId");
    	String customerId = request.getParameter("customerId");
    	double balance = Double.parseDouble(request.getParameter("balance")); 
    	double depositAmount=Double.parseDouble(request.getParameter("depositAmount"));		
	
		double newBalance = balance + depositAmount;
		
		System.out.println(accountId);
		System.out.println(depositAmount);
		System.out.println(balance);
		System.out.println(newBalance);
		
		DepositMoneyBean objDepositMoneyBean =new DepositMoneyBean();		
		
		objDepositMoneyBean.setBalance(newBalance);
		objDepositMoneyBean.setAccountId(accountId);
				
		DepositMoneyDao objDepositMoneyDao=new DepositMoneyDao();
		boolean dBInsertStatus=objDepositMoneyDao.setBalanceInAccountTable(objDepositMoneyBean);
		System.out.println(dBInsertStatus);
		
		TransactionBean objTransactionBean = new TransactionBean();		
		objTransactionBean.setAccountId(objDepositMoneyBean.getAccountId());
		objTransactionBean.setCustomerId(customerId);
		objTransactionBean.setTransactionType("Deposit");
		objTransactionBean.setAmount(depositAmount);
		
		TransactionDao objTransactionDao=new TransactionDao();	
		boolean transactionUpddateStatus=objTransactionDao.createTransactionTable(objTransactionBean);
		System.out.print(transactionUpddateStatus);
		
		
		
		if((dBInsertStatus =true) && (transactionUpddateStatus=true)){			
			request.getRequestDispatcher("/CashierHome.jsp").forward(request, response);
		}
		else{
			 request.getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
		}
    		
    }

}
