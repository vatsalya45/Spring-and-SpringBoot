package com.vatsalya.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public class DieselEngine implements Engine {

	public DieselEngine() {
		System.out.println("DieselEngine 0 prarm constructor ");
	}
	
	@Override
	public void run() {
		System.out.println("DieselEngine.run()");
	}

	@Override
	public String toString() {
		return "DieselEngine []";
	}
	
	

}
