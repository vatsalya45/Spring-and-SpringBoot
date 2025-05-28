package com.vatsalya.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("CoCl")
@Data
public class CoachingClass {

	@Value("${cc.name}")
	private String name;
	@Value("${cc.mathFees}")
	private Float mathFees;
	@Value("${cc.physicsFees}")
	private Float physicsFees;
	@Value("${cc.chemistryFees}")
	private Float chemistryFees;

}
