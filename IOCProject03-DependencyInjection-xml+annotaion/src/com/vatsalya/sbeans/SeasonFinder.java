//SeasonFinder.java(user defined java class as spring bean
package com.vatsalya.sbeans;


import java.time.DayOfWeek;
import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	
	private LocalDate date;//HAS-A property composition

	public SeasonFinder() {
		System.out.println("SeasonFinder::0-arg constructor");
	}

	@Autowired
	public void setDate(LocalDate date) {
		System.out.println("SeasonFinder.setDate()");
		this.date = date;
	}
	
	//Business method b.method
	
	public String showSeasonName() {
		
		System.out.println("SeasonFinder.showSeasonName()");
		int month = date.getMonthValue();
		
		if(month>=3 && month <=6) {
			
			return "Summer season";
		}
		else if(month>=7 && month <=9) {
			
			return "Rainy season";
		}
		else {
			return "Winter season";
		}
	}
	
	public String showWeekDay() {
		
		System.out.println("SeasonFinder.showWeekDay()");
		
		DayOfWeek day = date.getDayOfWeek();
		
		DayOfWeek SUNDAY = null;
		DayOfWeek SATURDAY = null;
		
		if(day == SUNDAY || day == SATURDAY) {
			
			return "Happy Weedend Day";
		}
		else {
			return "Happy Week Day";
		}
	}
	
}






