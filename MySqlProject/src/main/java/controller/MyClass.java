package controller;

public class MyClass {
	
	//AACD=CD
	public String method1(String str)
	{
		
		if(str.length() <=2)
   return str.replaceAll("A", "");
		 String s1= str.substring(0, 2);//AA
		 String s2=str.substring(2);//CD
		return s1.replaceAll("A", "")+s2;
		
		
		
		
	}
	//AACD=false
	public  boolean  method2(String str)
	{
		if(str.length()<=1)
			return false;
		if(str.length()==2)
			return true;
		 String s1= str.substring(0,2);
		 String s2=str.substring(str.length()-2);
		 return s1.equals(s2);
	}
	
	
	
	
	

}
