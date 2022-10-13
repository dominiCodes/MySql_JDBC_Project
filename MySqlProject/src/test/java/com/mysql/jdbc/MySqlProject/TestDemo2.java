package com.mysql.jdbc.MySqlProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import controller.MyClass;

public class TestDemo2 {
	
	MyClass obj;
	@Before
	public void setUp()
	{
		obj=new MyClass();
	}
	
	@Test
	public void testMethod1_Con1()
	{
		String actualResult=obj.method1("AACD");
		String expectedResult="CD";
		assertEquals(expectedResult, actualResult);
		
		
		
	}
	@Test
	public void testMethod1_Con2()
	{
		String actualResult=obj.method1("AATT");
		String expectedResult="TR";
		assertEquals(expectedResult, actualResult);
		
		
		
	}
	@Test
	public void testMethod2_Con1()
	{
		boolean actualResult=obj.method2("ABAB");
		boolean expectedResult=true;
		assertTrue(actualResult);
		
}
	@After
	public void tearDown()
	{
		obj=null;
	}
	
	@AfterClass
	public static void printMsg()
	{
		System.out.println("All test cases checked");
	}
	
	
	
	
	

}
