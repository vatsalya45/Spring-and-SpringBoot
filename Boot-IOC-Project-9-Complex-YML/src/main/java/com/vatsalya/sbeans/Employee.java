package com.vatsalya.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data
@ConfigurationProperties(prefix = "org.nit")
public class Employee {

	// simple properties
	private Integer eno;
	private String ename;
	// Array type properties
	private String[] favColours;
	// Collection type properties
	private List<String> nickNames;
	private Set<String> phoneNumbers;
	private Map<String, Object> idDetails;
	// HAS-A type properties
	private Company company;
}
