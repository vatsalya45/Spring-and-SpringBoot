package com.vatsalya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.vatsalya.sbeans.Vehicle;

@SpringBootApplication
@ImportResource("com/vatsalya/cfg/applicationContext.xml")
public class BootIocProject2Application {

	public static void main(String[] args) {
		
	//Get access of IOC Container
	ApplicationContext ctx= SpringApplication.run(BootIocProject2Application.class, args);

	//Get Target Spring Bean class object
	Vehicle car = ctx.getBean("Vehicle",Vehicle.class);
	
	//invoke the business method
	
	String msg = car.moving();
	System.out.println(msg);
	
	//close the container
	
	((ConfigurableApplicationContext)ctx).close();	
	}

}

