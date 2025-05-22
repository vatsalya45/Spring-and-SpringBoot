package com.vatsalya.sbeans;

import org.springframework.stereotype.Component;

@Component("bDart")
public  class BlueDart implements Courier {

	@Override
	public String dilevery(int oid) {
		
		return "Your order is kept with bluedart for the dilevery";
	}

}
