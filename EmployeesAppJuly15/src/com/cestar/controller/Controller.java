package com.cestar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cestar.dao.EmpDao;
import com.cestar.model.Employee;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	     String url = request.getServletPath();
	     
	     response.setContentType("text,html");
	     
	     PrintWriter out = response.getWriter();
	     
	     switch(url) {
	     
	     case "/display":{
	    	 
	    	 display(request,response);
	    	 
	    	 break;
	     }
	     
	     
	     case "/edit":
	     {
	    	 edit(request,response);
	    	 break;
	    	 
	     }
	     case "/update":
	     {
	    	 update(request,response);
	    	 break;
	    	 
	     }
	     
	     case "/delete":
	     {
	    	 delete(request,response);
	    	 break;
	    	 
	     }
	     
	     case "/insert":
	     {
	    	 
	    	 insert(request,response);
	    	 break;
	     }
	     default:{
	    	 out.print("Sorry, the required page is not available..!!");
	    	 
	     }
	     
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		EmpDao obj = new EmpDao();
		
		List<Employee> emps = obj.displayAllRecords();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("emps_list", emps);
		
		response.sendRedirect("display.jsp");
		
		
		
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EmpDao obj = new EmpDao();
		
		int id = Integer.parseInt(request.getParameter("e_id"));
		
		Employee emp = obj.getRecordById(id);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("emp", emp);
		
		session.setAttribute("old_id", id);
		
		response.sendRedirect("update.jsp");
				
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int u_id = Integer.parseInt(request.getParameter("e_id"));
		
		String u_name = request.getParameter("e_name");
		
		String u_city = request.getParameter("e_city");
		
		String u_dept = request.getParameter("e_dept");
		
		String u_email = request.getParameter("e_email");
		
		Employee updated_emp = new Employee(u_id,u_name,u_city,u_dept,u_email);
		
		HttpSession session = request.getSession();
		
	    int old_id = (int)session.getAttribute("old_id");
	
		EmpDao obj = new EmpDao();
		
		obj.updateRecord(updated_emp, old_id);
		
		display(request,response);

	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int e_id = Integer.parseInt(request.getParameter("e_id"));
		
		EmpDao obj = new EmpDao();
		
		obj.deleteRecord(e_id);
		
		display(request, response);
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// get it from url....insert?e_id=&e_name=&e_city=&e_dept=&e_email=
	 
		int id = Integer.parseInt(request.getParameter("e_id")); // e_id get it from url after clicking insert button
	 
	 String name = request.getParameter("e_name");
	 
	 String city = request.getParameter("e_city");
	 
	 String dept = request.getParameter("e_dept");
	 
	 String email = request.getParameter("e_email");
	 
	 Employee emp = new Employee(id,name,city,dept,email);
	 
	 EmpDao obj = new EmpDao();
	 
	 obj.insertRecord(emp);
	 
	 display(request, response);
	 
	
	
	
	}
	
}
