package controller;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeServiceImpl;
import model.Employee;
import service.EmployeeService;
import utility.JdbcUtility;

public class EmpApp {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		EmployeeService service=new EmployeeServiceImpl();
		System.out.println("Enter your choice \n 1. Add Employee \n 2.Get all Employee \n 3.Get Employee by ID\n 4.Update by ID \n 5.Delete Employee by ID\n 6.Login");
		int choice=  Integer.parseInt(scanner.nextLine());
		
		if(choice == 1) {
			
			System.out.println("Enter employee id");
			int id=Integer.parseInt(scanner.nextLine());
			System.out.println("Enter employee name");
			String name=scanner.nextLine();
			System.out.println("Enter employee phone");
			long ph=Long.parseLong(scanner.nextLine());
			System.out.println("Enter employee salary");
			double salary=Double.parseDouble(scanner.nextLine());
				System.out.println("Enter employee address");
				String addr=scanner.nextLine();
				Employee empObj=new Employee();
				empObj.setEmpId(id);
				empObj.setEmpName(name);
				empObj.setEmpPhone(ph);
				empObj.setEmpSalary(salary);
				empObj.setEmpAddress(addr);
				int k=service.addEmp(empObj);
				if(k>0) {
					System.out.println("Employee registered ");
				}
				
		}else if(choice == 2) {
			List<Employee> list= service.getAllEmp();
			list.forEach(emp-> System.out.println(emp.getEmpId() +" "+ emp.getEmpName()+" "+ emp.getEmpPhone()+" "+ emp.getEmpSalary()+ " " + emp.getEmpAddress()));
		}
		else if(choice == 3) {
			System.out.println("Enter the employe id: ");
			int empId= Integer.parseInt(scanner.nextLine());
			Employee emp= service.getEmpById(empId);
			System.out.println(emp.getEmpId() +" "+ emp.getEmpName()+" "+ emp.getEmpPhone()+" "+ emp.getEmpSalary()+ " " + emp.getEmpAddress());
		}
		else if(choice == 4) {
			System.out.println("Enter the employe id for updating salary");
			int empId2= Integer.parseInt(scanner.nextLine());
			service.updateById(empId2);		//updated in DB
}
		else if(choice == 5) {
			System.out.println("Enter the employe id for deleting emp");
			int empId3= Integer.parseInt(scanner.nextLine());
			service.deleteEmpById(empId3);
}
		else if(choice == 6) {
			System.out.println("Enter the id for login");
			int idLogin= Integer.parseInt(scanner.nextLine());
			String nameLogin= scanner.nextLine();
			boolean validLogin= service.login(idLogin, nameLogin);
			System.out.println(validLogin);
}else {
	System.out.println("Enter valid choice");
}

}

}
