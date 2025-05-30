package com.vatsalya.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("s")
@Data
public class StudentInfo {

	@Value("1001")
	private Integer id;
	@Value("${ss.name}")
	private String name;
	@Value("${ss.enrolledCourse}")
	private String enrolledCourse;
	@Value("#{CoCl.mathFees+CoCl.physicsFees+CoCl.chemistryFees}")
	// @Value("223")
	private Double totalFee;// math + physics + chemistry

	@Value("${os.name}") // fixed system properties
	private String osName;
	@Value("${user.name}") // fixed system properties
	private String windowsName;

	@Value("${Path}")
	private String pathData;// fixed environment variable

}
