package com.vatsalya.main;

import java.util.Locale;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.vatsalya.config.AppConfig;

public class Tester {

	public static void main(String[] args) {
		//Create IOC container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Read language code and country code from the enduser
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the language code");
		String language = sc.next();
		System.out.println("Enter the Country Code");
		String country = sc.next();
		
		//prepare Locale object having language + country code
		Locale locale = new Locale(language, country);
		
		
		// alternate -> Locale locale = Locale.of(language,country);
		//read  the message from the Locale specified properties file using ctx.getMeassage(-) method
		
		String m1 = ctx.getMessage("welcome.msg", new Object[] {"vasu"},"Default",locale);
		String m2 = ctx.getMessage("goodbye.msg", new Object[] {},"Default",locale);
		String m3 = ctx.getMessage("wishing.msg", new Object[] {},"Default",locale);
		
		//Printing the message
		System.out.println(m1+"...."+m2+"....."+m3);
		
		
		sc.close();
		//Close  the IOC container
		ctx.close();

	}

}
