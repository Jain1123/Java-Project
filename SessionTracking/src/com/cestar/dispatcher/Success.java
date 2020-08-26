package com.cestar.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Success
 */
@WebServlet("/Success")
public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Success() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	      response.setContentType("text/html");
	      
	      PrintWriter out = response.getWriter();
	      
	      //String name =request.getParameter("uname");
	      
	      //out.print("Welcome   "+name+"You logged in successfully");
	      
	     // Cookie[] cookies = request.getCookies();
	      
	      //String name = cookies[0].getValue();
	      
	      //String pass = cookies[1].getValue();
	      
	      //out.print("Welcome  "+name+"You are received as a cookie");
	      
	      //out.print("You typed your password  "+pass+" received as a cookie");
		      
	      
	      String uname = request.getParameter("u_name");
	      
	      out.print("Welcome  "+uname+" You are here by using hidden form field");
	      
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
