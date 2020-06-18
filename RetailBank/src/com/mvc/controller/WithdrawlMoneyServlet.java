package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.TransactionBean;
import com.mvc.bean.WithdrawlMoneyBean;
import com.mvc.dao.TransactionDao;
import com.mvc.dao.WithdrawlMoneyDao;

/**
 * Servlet implementation class Withdrawl Money
 */
@WebServlet("/ServletWithdrawlMoney")
public class WithdrawlMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WithdrawlMoneyServlet() {
        super();       
    }
          
    // This method will be invoked soon after this class is being invoked by Servlet
    // The request should contain parameter accountId
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	System.out.println("inside doget withdrawl money servelt");
     	String accountId = request.getParameter("accountId");
     	System.out.println(accountId);
     	WithdrawlMoneyBean objWithdrawlMoneyBean=new WithdrawlMoneyBean();
		objWithdrawlMoneyBean.setAccountId(accountId);
		WithdrawlMoneyDao objWithdrawlMoneyDao=new WithdrawlMoneyDao();		
		objWithdrawlMoneyBean=objWithdrawlMoneyDao.getWithdrawlPageDetails(objWithdrawlMoneyBean);
 
		request.setAttribute("objWithdrawlMoneyBean", objWithdrawlMoneyBean);		         
		request.getRequestDispatcher("/CashierWithdrawlMoney.jsp").forward(request, response);		
    }
 
    // This method will be invoked when the Submit button is clicked
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String accountId = request.getParameter("accountId");
    	String customerId = request.getParameter("customerId");
    	double balance = Double.parseDouble(request.getParameter("balance")); 
    	double withdrawlMoney=Double.parseDouble(request.getParameter("withdrawlMoney"));		
	
		double newBalance = balance - withdrawlMoney;
		
		System.out.println(accountId);
		System.out.println(withdrawlMoney);
		System.out.println(balance);
		System.out.println(newBalance);
		
		WithdrawlMoneyBean objWithdrawlMoneyBean =new WithdrawlMoneyBean();		
		objWithdrawlMoneyBean.setBalance(newBalance);
		objWithdrawlMoneyBean.setAccountId(accountId);
		
				
		WithdrawlMoneyDao objWithdrawlMoneyDao=new WithdrawlMoneyDao();
		boolean dBInsertStatus=objWithdrawlMoneyDao.setBalanceInAccountTable(objWithdrawlMoneyBean);
		System.out.println(dBInsertStatus);
		
		TransactionBean objTransactionBean = new TransactionBean();		
		objTransactionBean.setAccountId(accountId);
		objTransactionBean.setCustomerId(customerId);
		objTransactionBean.setTransactionType("Withdrawl");
		objTransactionBean.setAmount(withdrawlMoney);
		
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
