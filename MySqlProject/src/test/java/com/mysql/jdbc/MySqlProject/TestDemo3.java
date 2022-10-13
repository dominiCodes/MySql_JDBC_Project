package com.mysql.jdbc.MySqlProject;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import controller.MyClass;

@RunWith(Parameterized.class)
public class TestDemo3 {
	
	String input;
	String result;
	public TestDemo3(String input, String result)
	{
		this.input=input;
		this.result=result;
	}
@Parameters
public static Collection testAllCondition()
{
	Object expectedOutput[][]= {
			{"AACD","CD"},
			{"ACD","BCD"},
			{"AATT","TT"}
	};
	return Arrays.asList(expectedOutput);
}

@Test
public void testCase()
{
	MyClass m=new MyClass();
	assertEquals(result, m.method1(input));
}
	
}
