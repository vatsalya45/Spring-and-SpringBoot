package com.vatsalya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vatsalya.sbeans.Company;

@SpringBootApplication
public class BootIocProject08ConfiguratioPropertiesApplication {

	public static void main(String[] args) {
		// Get IOC container
		ApplicationContext ctx = SpringApplication.run(BootIocProject08ConfiguratioPropertiesApplication.class, args);

		// Get Company Class object reference
		Company com = ctx.getBean("comp", Company.class);
		System.out.println(com);
		// close the IOC container
		((ConfigurableApplicationContext) ctx).close();

	}

}
