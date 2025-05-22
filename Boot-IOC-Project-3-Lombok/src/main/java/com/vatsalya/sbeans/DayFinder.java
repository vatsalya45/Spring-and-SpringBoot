package com.vatsalya.sbeans;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("df") //Making class as Spring bean
public class DayFinder {

	@Autowired
	private LocalDate today;
	
	@Autowired
	private LocalDateTime time;
	
	public DayOfWeek findTodaysDay() {
		
		DayOfWeek day = today.getDayOfWeek();
		return day;
	}
	
	public String currentTime() {
		
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		
		String currentTime = "Hour :"+hour+" Minute :"+minute+" Second "+second+".";
		
		return currentTime;
	}
}
