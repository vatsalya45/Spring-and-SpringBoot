package com.vatsalya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vatsalya.sbeans.Hotel;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class BootIocProject6ValueAnnotationSpelApplication {

	public static void main(String[] args) {

		// get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootIocProject6ValueAnnotationSpelApplication.class, args);

		// get Hotel object reference
		Hotel hotel = ctx.getBean("hotel", Hotel.class);
		System.out.println(hotel);

		// Close the IOC
		((ConfigurableApplicationContext) ctx).close();
	}

}
