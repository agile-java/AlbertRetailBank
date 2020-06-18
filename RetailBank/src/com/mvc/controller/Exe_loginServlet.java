package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Exe_loginBean;

import com.mvc.dao.Exe_loginDao;

/**
 * Servlet implementation class Exe_loginServlet
 */
@WebServlet("/Exe_loginServlet")
public class Exe_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exe_loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException { // TODO Auto-generated
	 // method stub
	  //response.getWriter().append("Served at: ").append(request.getContextPath())
		  doPost(request, response);
	  ; }
	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Copying all the input parameters in to local variables
      
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        Exe_loginBean loginBean = new Exe_loginBean();
       //Using Java Beans - An easiest way to play with group of related data
                
        loginBean.setUserName(userName);
        loginBean.setPassword(password); 
        
        
        Exe_loginDao loginDao=new Exe_loginDao();
        
        Boolean userlogin=loginDao.loginuser(loginBean);
        System.out.println(userlogin);
        if(userlogin==true) {
        	System.out.println("inside a condition");
        	request.getRequestDispatcher("/home.jsp").forward(request, response);
        	        }
        else
        {
        	request.getRequestDispatcher("/executive_login.jsp").forward(request, response);
        }
	}

}
