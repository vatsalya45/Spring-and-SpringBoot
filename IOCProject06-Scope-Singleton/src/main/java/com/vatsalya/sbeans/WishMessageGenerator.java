package com.vatsalya.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("wmg")
@Scope("prototype")
public class WishMessageGenerator {

	@Autowired
	@Qualifier("dt")
	private LocalDate dt;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0 parameter constructor");
	}
	
}
