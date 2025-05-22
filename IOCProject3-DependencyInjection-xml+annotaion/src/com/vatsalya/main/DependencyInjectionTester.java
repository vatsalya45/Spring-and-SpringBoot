package com.vatsalya.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.vatsalya.sbeans.SeasonFinder;

public class DependencyInjectionTester {

	public static void main(String[] args) {
		
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/vatsalya/cfgs/applicationContext.xml");
		
		Object obj = ctx.getBean("sf");
		SeasonFinder sf = (SeasonFinder)obj;
		
		try {
			
			String msg = sf.showSeasonName();
			System.out.println("Season name : "+msg);
			
			String msg2 = sf.showWeekDay();
			System.out.println("Week day : "+msg2);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ctx.close();

	}

}
