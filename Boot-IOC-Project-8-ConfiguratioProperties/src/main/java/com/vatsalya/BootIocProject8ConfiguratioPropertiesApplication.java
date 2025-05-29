package com.vatsalya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vatsalya.sbeans.Company;

@SpringBootApplication
public class BootIocProject8ConfiguratioPropertiesApplication {

	public static void main(String[] args) {
		// Get IOC container
		ApplicationContext ctx = SpringApplication.run(BootIocProject8ConfiguratioPropertiesApplication.class, args);

		// Get Company Class object reference
		Company com = ctx.getBean("comp", Company.class);
		System.out.println(com);
		// close the IOC container
		((ConfigurableApplicationContext) ctx).close();

	}

}
