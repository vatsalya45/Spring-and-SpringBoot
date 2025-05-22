package com.vatsalya.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {

	//Bean Property
	@Autowired
	private LocalDate ldt;
	
	//Business method
	public String findSeason() {
		
		//Get current Month
		int month = ldt.getMonthValue();
		//Show Season name 
		
		if(month>=3 && month <=6)
			return "Summer Season";
		else if (month >=7 && month <= 10)
			return "Monsoon Season";
		else 
			return "Winter Season";
	}
}
