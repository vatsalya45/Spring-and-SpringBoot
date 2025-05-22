package com.vatsalya.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages="com.vatsalya")

public class AppConfig {

	@Bean(name="dt")
	@Scope("singleton")
	public LocalDate createDate() {
		
		System.out.println("AppConfig.createDate()");
		return LocalDate.now();
	}
	@Bean(name="dt1")
	@Scope("singleton")
	public LocalDate createDate1() {
		
		System.out.println("AppConfig.createDate()");
		return LocalDate.now();
	}
	
}
