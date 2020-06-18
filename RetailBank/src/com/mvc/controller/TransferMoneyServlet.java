package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.TransactionBean;
import com.mvc.bean.TransferMoneyBean;
import com.mvc.dao.TransactionDao;
import com.mvc.dao.TransferMoneyDao;

/**
 * Servlet implementation class Transfer Money
 */
@WebServlet("/ServletTransferMoney")
public class TransferMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransferMoneyServlet() {
        super();       
    }
          
    // This method will be invoked soon after this class is being invoked by Servlet
    // The request should contain parameter accountId
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	
    	String sourceAccountId = request.getParameter("accountId");
    	
     	TransferMoneyBean objTransferMoneyBean=new TransferMoneyBean();
		objTransferMoneyBean.setSourceAccountId(sourceAccountId);
		TransferMoneyDao objTransferMoneyDao=new TransferMoneyDao();		
		objTransferMoneyBean=objTransferMoneyDao.getTransferPageDetails(objTransferMoneyBean);
		
		request.setAttribute("objTransferMoneyBean", objTransferMoneyBean);		         
		request.getRequestDispatcher("/CashierTransferMoney.jsp").forward(request, response);

		
    }
 
    // This method will be invoked when the Submit button is clicked
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	TransferMoneyBean objTransferMoneyBean=new TransferMoneyBean();
    	objTransferMoneyBean.setSourceAccountId(request.getParameter("sourceAccountId"));
    	objTransferMoneyBean.setTargetAccountId(request.getParameter("targetAccountId"));
    	objTransferMoneyBean.setSourceCustomerId(request.getParameter("sourceCustomerId"));
    	
    	objTransferMoneyBean.setTransferMoney(Double.parseDouble(request.getParameter("transferMoney")));
     	
    	TransferMoneyDao objTransferMoneyDao=new TransferMoneyDao();
    	objTransferMoneyBean=objTransferMoneyDao.getTransferPageDetails(objTransferMoneyBean);
    	
      	double transferMoney = objTransferMoneyBean.getTransferMoney();  
      	System.out.println("tsarbalance");
      	System.out.println(objTransferMoneyBean.getTargetAccountBalance());
		double newSourceAccountBalance = objTransferMoneyBean.getSourceAccountBalance() - transferMoney;
		double newTargetAccountBalance = objTransferMoneyBean.getTargetAccountBalance() + transferMoney;
		
		
		objTransferMoneyBean.setSourceAccountBalance(newSourceAccountBalance);
	 	objTransferMoneyBean.setTargetAccountBalance(newTargetAccountBalance);
		 
		boolean dBInsertStatus=objTransferMoneyDao.setBalanceInAccountTable(objTransferMoneyBean);
		System.out.println(dBInsertStatus);
		
		
		TransactionBean objTransactionBean = new TransactionBean();	
		TransactionDao objTransactionDao=new TransactionDao();	
		
		objTransactionBean.setAccountId(objTransferMoneyBean.getSourceAccountId());
		objTransactionBean.setCustomerId(objTransferMoneyBean.getSourceCustomerId());
		objTransactionBean.setTransactionType("Withdrawal");
		objTransactionBean.setAmount(transferMoney);
		System.out.print(objTransferMoneyBean.getTargetCustomerId());
		System.out.print(objTransferMoneyBean.getTargetCustomerId());
		
		boolean transactionUpddateStatus=objTransactionDao.createTransactionTable(objTransactionBean);
		System.out.print(transactionUpddateStatus);
		
		objTransactionBean.setAccountId(objTransferMoneyBean.getTargetAccountId());
		objTransactionBean.setCustomerId(objTransferMoneyBean.getTargetCustomerId());
		objTransactionBean.setTransactionType("Deposit");
		objTransactionBean.setAmount(transferMoney);		
		System.out.print(objTransferMoneyBean.getTargetCustomerId());
		
		boolean transactionUpdateStatus2=objTransactionDao.createTransactionTable(objTransactionBean);
		System.out.print(transactionUpdateStatus2);
		
			
		if((dBInsertStatus =true) && (transactionUpddateStatus=true)  &&  (transactionUpdateStatus2=true)  ){				
			request.getRequestDispatcher("/CashierHome.jsp").forward(request, response);
		}
		else{
			 request.getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
		}
    		
    }

}
