//FlipKart.java it is the target class
package com.vatsalya.sbeans;


import java.text.DecimalFormat;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fk")
public  class FlipKart {
	//HAS-A property 
	
	@Autowired
	@Qualifier("bDart")
	private Courier courier;
	
	//Business method 
	public String shopping(String[] items, float[] fs) {
		
		//Calculate the bill amount
		double billAmount = 0.0;
		
		for(double p :fs) {
			billAmount = billAmount+p;
			//Rounding off
			DecimalFormat dc=new DecimalFormat("00.00");
			String format = dc.format(billAmount);
			billAmount=Double.parseDouble(format);
			
		}
		
		//Generate the order it (random numbers)
		
		int oid = new Random().nextInt(1000);
		//deliver the product using courier 
		String msg = courier.dilevery(oid);
		
		return Arrays.toString(items)+" items with billamount Rs "+billAmount+" "+msg;
	}
}
