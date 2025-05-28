package com.vatsalya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.vatsalya.sbeans.StudentInfo;

@SpringBootApplication

public class BootIocProject7ValueAnnotationApp {

	public static void main(String[] args) {
		// get IOC Container
		ApplicationContext cts = SpringApplication.run(BootIocProject7ValueAnnotationApp.class, args);

		// get Student info
		StudentInfo si = cts.getBean("s", StudentInfo.class);
		System.out.println(si);

		// Close the IOC container
		((ConfigurableApplicationContext) cts).close();
	}

}
