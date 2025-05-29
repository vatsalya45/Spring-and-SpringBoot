package com.vatsalya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vatsalya.sbeans.Employee;

@SpringBootApplication
public class BootIocProject9ComplexYmlApplication {

	public static void main(String[] args) {
		// Get the IOC container
		ApplicationContext ctx = SpringApplication.run(BootIocProject9ComplexYmlApplication.class, args);
		// Get the Object reference
		Employee employee = ctx.getBean("emp", Employee.class);
		System.out.println(employee);
		// Close the IOC container
		((ConfigurableApplicationContext) ctx).close();

	}

}
