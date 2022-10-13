package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import service.EmployeeService;
import utility.JdbcUtility;

public class EmployeeServiceImpl implements EmployeeService { //Implementing the services of EmoployeService Interface
//store data to DB server
	public int addEmp(Employee employee)  {

		int status=0;
		try
		{
   //to connect with DB
	Connection connection=	JdbcUtility.connect(); // calling the connection function from the JDBCutility class
		//Creating statement object
	//Statement s=	connection.createStatement(); // this one is complicated so dont use this, instead use preparedstatement
	// PreparedStatement ps=prepareStatement(String sqlQuery)throws SQL exception
	//Create table Employee(emp_id int primary key, emp_name varchar(40), emp_phone bigint, emp_salary real, emp_address varchar(40));
	 
	PreparedStatement  ps= connection.prepareStatement("insert into Employee values(?,?,?,?,?)");
	ps.setInt(1, employee.getEmpId());
	ps.setString(2, employee.getEmpName());
	ps.setLong(3,employee.getEmpPhone());
	ps.setDouble(4, employee.getEmpSalary());
	ps.setString(5, employee.getEmpAddress());
	
		status=ps.executeUpdate(); // this statement is important and used to execute and update the query
		//(used for insert, update and delete)
		
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		return status; // will return 0 or 1 based on whether the query is executed or not
	}

	public List<Employee> getAllEmp() {
		List<Employee> list=new ArrayList<Employee>();
		try
		{
		Connection connection=	JdbcUtility.connect();// first in evvery function do the connection
    
     	PreparedStatement ps= connection.prepareStatement("select * from Employee");
     
       ResultSet rs=ps.executeQuery(); // executeQuery return a cursor which helps to fectch the dara from DB
       while(rs.next())  // fetching data through ResultSet obj 
       {
    	   Employee employee=new Employee();
    	  // rs.getInt(1);
    	int id=   rs.getInt("emp_id");  // we can fetch by typing the column name or column no
    	String name=rs.getString("emp_name");
    	long ph=rs.getLong(3);
    	double salary=rs.getDouble(4);
    	String address=	rs.getString(5);
    	employee.setEmpId(id);
    	employee.setEmpName(name);
    	employee.setEmpPhone(ph);
    	employee.setEmpSalary(salary);
    	employee.setEmpAddress(address);
    	list.add(employee);  
   }
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			
		}
		return list;
	}

	public Employee getEmpById(int employeeId) {
		
		try {
			Connection connection= JdbcUtility.connect();
			PreparedStatement ps= connection.prepareStatement("SELECT * from Employee WHERE emp_id =" + employeeId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {  // fetching data through ResultSet obj 
				Employee employee=new Employee();
				int id=   rs.getInt(1);  // we can fetch by typing the column name or column no
		    	String name=rs.getString(2);
		    	long ph=rs.getLong(3);
		    	double salary=rs.getDouble(4);
		    	String address=	rs.getString(5);
		    	employee.setEmpId(id);
		    	employee.setEmpName(name);
		    	employee.setEmpPhone(ph);
		    	employee.setEmpSalary(salary);
		    	employee.setEmpAddress(address);
		    	return employee;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void updateById(int employeeId) {
//		Employee employee=  new Employee();
		try
		{
   //to connect with DB
	Connection connection=	JdbcUtility.connect(); // calling the connection function from the JDBCutility class
	
	PreparedStatement ps= connection.prepareStatement("UPDATE Employee SET emp_salary= 1000000 WHERE emp_id =?");
	ps.setInt(1, employeeId);
	
		int status= ps.executeUpdate(); // this statement is important and used to execute and update the query
		//(used for insert, update and delete)
		if(status>0) System.out.println("Suscefully updated");
		else System.out.println("Not updated");
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
//		return employee;
	}

	public void deleteEmpById(int employeeId) {
		// TODO Auto-generated method stub
		try
		{
   //to connect with DB
	Connection connection=	JdbcUtility.connect(); // calling the connection function from the JDBCutility class
	
	PreparedStatement ps= connection.prepareStatement("DELETE FROM Employee WHERE emp_id =?");
	ps.setInt(1, employeeId);
	
		int status= ps.executeUpdate(); // this statement is important and used to execute and update the query
		//(used for insert, update and delete)
		if(status>0) System.out.println("Suscefully Deleted");
		else System.out.println("Not updated");
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	
		
	}
	
	public boolean login(int id, String name) {
		boolean status= false;
		try {
			Connection connection= JdbcUtility.connect();
			PreparedStatement ps= connection.prepareStatement("SELECT * from Employee WHERE emp_id =? AND emp_name=?");
			ps.setInt(1,id);
			ps.setString(2,name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				status= true;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

}
