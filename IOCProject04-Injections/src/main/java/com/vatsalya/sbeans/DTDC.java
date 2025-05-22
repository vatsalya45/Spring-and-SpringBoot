package com.vatsalya.sbeans;

import org.springframework.stereotype.Component;

@Component("dtdc")
public  class DTDC implements Courier {

	@Override
	public String dilevery(int oid) {
		
		return "Order items are kept with DTDC for the dilevery";
	}

}
