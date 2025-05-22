package com.vatsalya;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.vatsalya.sbeans.DayFinder;


@SpringBootApplication
public class BootIocProject3LombokApplication {

	@Bean(name="idf")
	 LocalDate createDate(){
		
		return LocalDate.now();
	}
	
	@Bean(name="idft")
	 LocalDateTime creDateTime() {
		
		return LocalDateTime.now();
	}
	
	
	
	public static void main(String[] args) {
		
		//get the IOC container
		
		ApplicationContext ctx= SpringApplication.run(BootIocProject3LombokApplication.class, args);
		
		//get Target spring bean class object
		
		DayFinder finder = ctx.getBean("df",DayFinder.class);
		//SalaryCalculator salaryCalculator = ctx.getBean("sc",SalaryCalculator.class);
		
		//Invoke the b method
		
		DayOfWeek todaysDay = finder.findTodaysDay();
		String time = finder.currentTime();
		System.out.println("Todays day :"+todaysDay);
		System.out.println("Current Time :"+time);
		
		//String totalSalary = salaryCalculator.totalSalary();
		//ystem.out.println(totalSalary);
		
		
		
		//close the IOC container
		
		((ConfigurableApplicationContext)ctx).close();
		
	}

}
