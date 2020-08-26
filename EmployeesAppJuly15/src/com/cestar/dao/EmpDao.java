package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.Employee;

public class EmpDao {
	public Connection getConnection()
	
	{
		String url="jdbc:mysql://localhost:3306/emps";
		
		String user = "root";
		
		String pwd = "";
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,user,pwd);
			
			System.out.println("connection successful:");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

	
	public List<Employee> displayAllRecords()
	{
		List<Employee> emps = new ArrayList<>();
		
		String sql = "select * from employees";
		
		Connection con = getConnection();
		
		try {
			Statement st = con.createStatement();
	        
			ResultSet rs = st.executeQuery(sql);
			
			
		while(rs.next())
		{
			Employee emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			
			emps.add(emp);
			
		}
		
		System.out.println(emps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emps;
		
		
		
	}
	
	public Employee getRecordById(int emp_id)
	{
		
		Connection con = getConnection();
		
		String sql = "select * from employees where id=?";
		
		Employee emp = null;
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, emp_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				
				
				
			}

			System.out.println(emp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
		
	}
	
	public void updateRecord(Employee updated_emp,int old_id) {
		
		Connection con = getConnection();
		
		String sql = "update employees set id=?, name=?, city=?, department=?, email=? where id=?";
		
		int status = 0;
		
		try {
			
			
			PreparedStatement pstmt = con.prepareStatement(sql);
		    
			pstmt.setInt(1, updated_emp.getId());
			pstmt.setString(2, updated_emp.getName());
			pstmt.setString(3, updated_emp.getCity());
			pstmt.setString(4, updated_emp.getDepartment());
			pstmt.setString(5, updated_emp.getEmail());
			pstmt.setInt(6, old_id);
			
			status = pstmt.executeUpdate();
			
			if(status>0)
			{
				System.out.println("Record updated:");
			}
			else
			{
				System.out.println("Try again:");
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void deleteRecord(int e_id)
	{
		Connection con = getConnection();
		
		String sql = "delete from employees where id=?";
		
	    int status = 0;
	    
	    try {
			PreparedStatement pstmt = con.prepareStatement(sql);
		
            pstmt.setInt(1, e_id); // variable that is returning value	    
	    
            status = pstmt.executeUpdate();
            
            if(status>0)
            {
            	System.out.println("Record deleted successfully:");
            	
            }
            else {
            	System.out.println("Try again, please..!!!");
            }
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	    
	    public void insertRecord(Employee emp) // employee emp is created in cronroller servlet
	    {
	    	Connection con = getConnection();
	    	
	    	String sql = "insert into employees values(?,?,?,?,?)";
	    	
	    	int status = 0;
	    	
	    	try {
				
	    		PreparedStatement pstmt = con.prepareStatement(sql);
			
	    		pstmt.setInt(1, emp.getId()); // values are coming from form
	    		
	    		pstmt.setString(2, emp.getName());
	    		
	    		pstmt.setString(3, emp.getCity());
	    		
	    		pstmt.setString(4, emp.getDepartment());
	    		
	    		pstmt.setString(5, emp.getEmail());
	    		
	    		status = pstmt.executeUpdate();
	    		
	    		if(status>0)
	    		{
	    			System.out.println("Record insert successfully");
	    		}
	    		else
	    		{
	    			System.out.println("Please, try again..!!!");
	    			
	    		}
	    		

	    		
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
