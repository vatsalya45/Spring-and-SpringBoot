package com.vatsalya.sbeans;

import java.time.*;

public class WishMessageGenerator {

	private LocalTime time;
	private LocalDate date;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerate::0-arg constructor");
		
	}

	public void setTime(LocalTime time) {
		System.out.println("wishMessageGenerator.setTime()");
		this.time = time;
	}

	public void setDate(LocalDate date) {
		System.out.println("wishMessageGenerator.setDate()");
		this.date = date;
	}
	
	public String showWishMessage(String user) {
		
		System.out.println("WishMessageGenerator.showWishMessage()");
		
		int hour=time.getHour();
		if(hour<12)
			return "Good Morning: "+user;
		else if(hour<16)
			return "Good Afternoon: "+user;
		else if(hour<18)
			return "Good Evening: "+user;
		else
			return "Good Night: "+user;
		
	}
	
public String showSeason(String user) {
		
		int month=date.getMonthValue();
		if(month<=4)
			return "Summer ";
		else if(month<=8)
			return "Rainy ";
		else 
			return "winter ";
		
	}
	

}
