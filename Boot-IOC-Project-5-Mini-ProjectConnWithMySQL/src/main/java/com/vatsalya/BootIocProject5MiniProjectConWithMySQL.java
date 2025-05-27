package com.vatsalya;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vatsalya.controller.EmployeeOperationsController;
import com.vatsalya.model.Employee;

@SpringBootApplication
public class BootIocProject5MiniProjectConWithMySQL {

	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a = 0;
		System.out.println("Select the option");
		System.out.println("1. Find the Employee by desg.");
		System.out.println("2. Register the new Employee");
		a = sc.nextInt();
		switch (a) {
		case 1: {

			findEmployeeByDesg(args);
		}
			break;
		case 2: {

			registerEmployee(args);
		}
			break;
		}
	}

	public static void findEmployeeByDesg(String[] args) {

		try (
				// get Access to the IOC container

				ConfigurableApplicationContext ctx = SpringApplication.run(BootIocProject5MiniProjectConWithMySQL.class,
						args);

				// get Scanner Class Object
				sc;) {
			// get Controller Spring Bean Class Object Reference

			EmployeeOperationsController controller = ctx.getBean("payroll", EmployeeOperationsController.class);

			// read inputs from the end user
			System.out.println("Enter the Desg1");
			String d1 = sc.next();
			System.out.println("Enter the Desg2");
			String d2 = sc.next();
			System.out.println("Enter the Desg3");
			String d3 = sc.next();

			// invoke the b method

			List<Employee> list = controller.showAllEmployeeByDesgs(d1, d2, d3);

			// display result

			System.out.println("Employees belonging to the " + d1 + ", " + d2 + ", " + d3 + ".");
			list.forEach(emp -> {
				System.out.println(emp);
			});
		} // try--> At this the Object created in the try with resources block will be
			// closed automatically
		catch (Exception e) {
			System.out.println("Internal Problems ::" + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void registerEmployee(String[] args) {
		// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootIocProject5MiniProjectConWithMySQL.class, args);
		// get IOC container ref object
		EmployeeOperationsController controller = ctx.getBean("payroll", EmployeeOperationsController.class);

		// Read input from the user
		System.out.println("Enter the name of the Employee.");
		String name = sc.next();

		System.out.println("Enter the job role.");
		String desg = sc.next();

		System.out.println("Enter the salary.");
		double salary = sc.nextDouble();

		System.out.println("Enter the Deptno(10,20,30,40).");
		int deptNo = sc.nextInt();

		// create Employee class object
		Employee emp = new Employee();
		emp.setEname(name);
		emp.setJob(desg);
		emp.setSalary(salary);
		emp.setDeptno(deptNo);

		try {
			String resultMsg = controller.processEmployee(emp);
			System.out.println(resultMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
	}
}// class
