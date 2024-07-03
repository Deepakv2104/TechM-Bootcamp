package org.examples;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
public static void main(String args[]) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
	EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");
	
	while(true) {
		System.out.println("1.Select");
		System.out.println("2.Insert");
		System.out.println("3.Update");
		System.out.println("4.Delete");
		System.out.println("5.Stop");
		
		System.out.println("Enter your Option:");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		
		if(ch==1) {
			List<Employee> employees = dao.selectAllEmployees(new Employee());
		    for (Employee employee : employees) {
		        System.out.println(employee);
		    }
		}else if(ch==2) {
			System.out.println("Enter the Employee Id:");
			int id=sc.nextInt();
			System.out.println("Enter the Employee Name:");
			String name=sc.next();
			System.out.println("Enter the Employee Salary:");
			float salary=sc.nextFloat();
			
			int status=dao.insertEmployee(new Employee(id,name,salary));
			System.out.println("Row Inserted Successfully" +status);
		}else if(ch==3) {
			System.out.println("Enter the Employee Id to update details:");
			int id=sc.nextInt();
			
			System.out.println("Enter the Employee New Salary:");
			float salary=sc.nextFloat();
			
			int status=dao.updateEmployee(new Employee(salary,id));
			System.out.println("Row Inserted Successfully" +status);
			
		}else if(ch==4) {
			System.out.println("Enter the Employee Id to delete:");
			int id=sc.nextInt();
			
			int status=dao.deleteEmployee(new Employee(id));
			System.out.println("Row Inserted Successfully" +status);
		}else if(ch==5) {
			System.out.println("Program is Stopped");
			break;
		}else {
			System.out.println("Invalid Option");
			break;
		}
	}
  }
}