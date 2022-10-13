package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {  // providing services
	
	//I want to store my employee information permanently to DB server
	
	public int addEmp(Employee employee);
	//I want to fetch employee info from DB server
	public List<Employee> getAllEmp();
	//I want fetch using employee id
	public Employee getEmpById(int employeeId);
	//I want to update employee info using employee id
	public void updateById(int employeeId);
	// I want to delete employee using employee id
	public void deleteEmpById(int empId);
	//I want to do the login based on id and phNo
	public boolean login(int id, String ph);
	

	

}
