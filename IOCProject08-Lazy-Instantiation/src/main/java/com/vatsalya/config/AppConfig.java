package com.vatsalya.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.vatsalya")
public class AppConfig {

	@Bean(name = "ldt")
	@Scope("singleton")
	@Lazy(true)
	public LocalDateTime createDate() {
		System.out.println("AppConfig.createDate()");
		return LocalDateTime.now();
	}
	
	@Bean(name = "ldt1")
	@Scope("singleton")
	@Lazy(true)
	public LocalDateTime crateDate1() {
		
		System.out.println("AppConfig.crateDate1()");
		return LocalDateTime.now();
	}
}
