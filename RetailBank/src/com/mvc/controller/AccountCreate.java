package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Account;
import com.mvc.dao.AccountDao;

/**
 * Servlet implementation class AccountCreate
 */
@WebServlet("/AccountCreate")
public class AccountCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCreate() {
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
		
		
		int customerid = Integer.parseInt(request.getParameter("customerid"));
        String accounttype = request.getParameter("actype");
        double balance =Double.parseDouble(request.getParameter("deposit"));
        Account acbean=new Account();
        
        acbean.setCustomerid(customerid);
        acbean.setAccounttype(accounttype);
        acbean.setBalance(balance);
        
        AccountDao accountcreatedao=new AccountDao();
        boolean result=accountcreatedao.createAccount(acbean);
        if(result==true) {
        	System.out.println("value inserted succeccfully");
        	request.getRequestDispatcher("/home.jsp").forward(request, response);
        	        }
        else
        {
        	request.getRequestDispatcher("/cashier.jsp").forward(request, response);
        }
	}

}
