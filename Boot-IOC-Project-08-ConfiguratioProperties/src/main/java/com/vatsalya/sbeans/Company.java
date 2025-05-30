package com.vatsalya.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("comp")
@Setter
@ToString
@ConfigurationProperties(prefix = "org.nit")
//@PropertySource("App.properties")
public class Company {

	private String name;
	private String addrs;
	private Long pincode;
	private Long mobileNumber;
	@Value("${nit.size}")
	private Integer size;

	// Inject Values to the Array/List/Set Type Spring Bean

	private String[] branches;// String

	private List<String> owners;// List

	private Set<Long> phones;// Set

	// Inject Values to the Map, HAS-A Type Spring Bean
	private Map<String, Object> idDetails;
	private License license;// HAS-A

}
