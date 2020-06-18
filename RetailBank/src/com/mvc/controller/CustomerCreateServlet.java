package com.mvc.controller;

import java.io.IOException
;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.CustomerBean;

import com.mvc.dao.Exe_loginDao;


/**
 * Servlet implementation class customerCreate
 */
@WebServlet("/CustomerCreateServlet")
public class CustomerCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 	int ssnid = Integer.parseInt(request.getParameter("ssnid"));
	        String name = request.getParameter("name");
	        int age =Integer.parseInt(request.getParameter("age"));
	        String address = request.getParameter("address");
	        String state = request.getParameter("state");
	        String city = request.getParameter("city");
	        
	       CustomerBean custBean = new CustomerBean();
	       //Using Java Beans - An easiest way to play with group of related data
	                
	         custBean.setSsnid(ssnid);
	         custBean.setCustomername(name);
	         custBean.setAge(age);
	         custBean.setAddress(address);
	         custBean.setState(state);
	         custBean.setCity(city);
	        
	        
	        Exe_loginDao customercreateDao=new Exe_loginDao();
	        
	        Boolean customerinsert=customercreateDao.customercreate(custBean);
	        System.out.println(customerinsert);
	        if(customerinsert==true) {
	        	System.out.println("value inserted succeccfully");
	        	request.getRequestDispatcher("/home.jsp").forward(request, response);
	        	        }
	        else
	        {
	        	request.getRequestDispatcher("/cashier.jsp").forward(request, response);
	        }
	}

}
