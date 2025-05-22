package com.vatsalya.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("wmg")
@Scope("singleton")
@Lazy(true)
public class WishMessageGenrator {
	
	
	@Autowired
	@Qualifier("ldt")
	private LocalDateTime ldt;
	
	public WishMessageGenrator() {
		
		System.out.println("WishMessageGenrator::0-param constructor");
	}
}
