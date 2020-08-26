package com.cestar.dao;

import com.cestar.model.Employee;

public class DaoRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmpDao obj = new EmpDao();
		
		//obj.getConnection();
		
		//obj.displayAllRecords();
		
		//obj.getRecordById(786);
	  // Employee e_updated = new Employee(889,"King Bruce","Detroit","IT","king@yahoo.com");
	
	  // int old_id = 786;
	   //obj.updateRecord(e_updated, old_id);
		
		//obj.deleteRecord(111);
		//obj.insertRecord(888,"jain","def","IT","sakshi@gmail.com");
	   
		Employee e = new Employee(111,"Fisher Hallman","Kitchner","Procurement","fisher@yahoo.com");
	    
		obj.insertRecord(e);
	
	}

}
