package com.vatsalya.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("pinfo")
@PropertySource(value = "com/vatsalya/commons/Info.properties")
public class PersonInfo {
	//injecting through properties file
	
	@Value("${person.name}")
	private String name;
	
	@Value("${person.job}")
	private String job;
	
	@Value("${person.adrr}")
	private String adrr;
	
	@Value("${person.age}")
	private Integer age;
	
	//injecting direct values
	
	@Value("9090909090")
	private Long number;
	
	//injecting the system properties
	@Value("${os.name}")
	private String osName;
	
	@Value("${os.ver}")
	private String osVersion;
	
	
	//Injecting the environmental values
	@Value("${Path}")
	private String path;
}
