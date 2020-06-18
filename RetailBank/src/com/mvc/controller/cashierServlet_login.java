package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.cashierBean;
import com.mvc.dao.cashierloginDao;

/**
 * Servlet implementation class cashierServlet
 */
@WebServlet("/cashierServlet")
public class cashierServlet_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cashierServlet_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Copying all the input parameters in to local variables
	      
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        cashierBean loginBean = new cashierBean();
       //Using Java Beans - An easiest way to play with group of related data
                
        loginBean.setUsername(userName);
        loginBean.setPassword(password); 
        
        
        cashierloginDao loginDao=new cashierloginDao();
        
        Boolean userlogin=loginDao.loginuser(loginBean);
        System.out.println(userlogin);
        if(userlogin==true) {
        	System.out.println("inside a condition");
        	request.getRequestDispatcher("/CashierHome.jsp").forward(request, response);
        	        }
        else
        {
        	request.getRequestDispatcher("/cashier.jsp").forward(request, response);
        }
	}

	}


