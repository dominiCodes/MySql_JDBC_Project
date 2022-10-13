package com.mysql.jdbc.MySqlProject;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestDemo6 {

	public static void main(String[] args) {


	Result result=	JUnitCore.runClasses(TestDemo4.class);
		
		if(result.getFailureCount()==0)
		{
			System.out.println("all test cases are passed");
		}
		else
		{
			for(Failure fail:result.getFailures())
			{
				System.out.println(fail.getMessage());
			}
		}
		System.out.println("result "+ " "+result.wasSuccessful());
		
		

	}

}
