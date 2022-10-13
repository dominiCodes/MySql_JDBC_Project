package com.mysql.jdbc.MySqlProject;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.EmployeeServiceImpl;
import model.Employee;
import service.EmployeeService;

public class TestDemo4 {
	
	EmployeeService service;
	@Before
	public void setUp()
	{
		service=new EmployeeServiceImpl();
	}
	
	@Test
	public void testMethod1()
	{
		
	Employee emp=	service.getEmpById(1);
		assertNull("emp should not be null",emp);
		
		
	}
	

}
