package com.vatsalya.sbeans;

import org.springframework.stereotype.Component;

@Component("pEngine")
public class PetrolEngine implements Engine {

	public PetrolEngine() {
		System.out.println("PetrolEngine:: 0 param constructor");
		
	}
	
	@Override
	public void run() {
		System.out.println("PetrolEngine.run()");

	}

	@Override
	public String toString() {
		return "PetrolEngine []";
	}
	

}
