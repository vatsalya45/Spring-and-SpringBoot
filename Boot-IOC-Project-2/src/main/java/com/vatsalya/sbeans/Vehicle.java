package com.vatsalya.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Vehicle")
public class Vehicle {
	
	@Autowired
	@Qualifier("engine")
	private Engine engine;
	
	public Vehicle() {
		System.out.println("Vehicle:: 0 param contructor");
		
	}
	public String moving() {
		
		System.out.println("Vehicle.moving()");
		
		return "Vehicle is running with "+engine;
	}
	
}
