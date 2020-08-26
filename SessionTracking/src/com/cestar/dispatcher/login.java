package com.cestar.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet(name="UserLogin",urlPatterns ={"/UserLogin"})
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
	    
	    String name = request.getParameter("uname");
	    
	    String pass = request.getParameter("upass");
	    
	    
	    //Cookie ck1 = new Cookie("name" +name;)
	    
	    
	    out.print("Welcome  "+name);
	    
	    if(pass.equals("password"))
	    {
	    	//RequestDispatcher rd = request.getRequestDispatcher("Success");
	    	
	    //    rd.forward(request, response);
	      
	    	  response.sendRedirect("Success");
	    }
	    
	    else
	    {
	    	out.print("Sorry password is not correct");
	    	RequestDispatcher rd = request.getRequestDispatcher("user.html");
	    	
	    	rd.include(request,response);
	    	
	    	
	    }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
