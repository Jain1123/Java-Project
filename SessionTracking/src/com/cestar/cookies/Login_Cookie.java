package com.cestar.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login_Cookie
 */
@WebServlet("/Login_Cookie")
public class Login_Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Cookie() {
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
	     
	     String name=request.getParameter("uname");
	     
	     String pass = request.getParameter("upass");
	     
	     Cookie c1 = new Cookie("uname",name);
	     
	     Cookie c2 = new Cookie("upass",pass);
	     
	     response.addCookie(c1);
	     
	     response.addCookie(c2);
	     
	     response.sendRedirect("Success");
	     
	     
	     
	     
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
