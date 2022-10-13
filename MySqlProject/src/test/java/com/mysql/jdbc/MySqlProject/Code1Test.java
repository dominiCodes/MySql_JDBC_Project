package com.mysql.jdbc.MySqlProject;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;
import dao.Code1;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)

public class Code1Test {
double principal;
String loanType;
double time;
double result;
Code1 ec;
@Before
public void initialize() {
ec = new Code1();
}
public Code1Test(double principal, String loanType, double time, double result) {
this.principal = principal;
this.loanType = loanType;
this.time = time;
this.result = result;
}
@Parameterized.Parameters
public static Collection emiTest() {
Object arr[][]= {
{100000,"Housing Loan",4,2088.4414980626916},{100000,"Personal Loan",2, 4171.442649786066},{100000,"Vehicle Loan",3,2782.062266820467}};
   return Arrays.asList(arr);
}


@Test
public void testCase1() {
   System.out.println("Principal :"+principal+" Loan Type: "+loanType+" Time: "+time );
   assertEquals((int)result,(int) ec.calculateEMI(principal, loanType,time),0.0);
  
}
}