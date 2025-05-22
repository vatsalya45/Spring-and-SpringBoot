package com.vatsalya.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.vatsalya.sbeans.*;

public class DependencyInjectionTester {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext ctx= new FileSystemXmlApplicationContext("src/com/vatsalya/cfgs/ApplicationContext.xml");
		
		Object obj=ctx.getBean("wmg");
		
		WishMessageGenerator generator=(WishMessageGenerator)obj;
		
		String msg=generator.showWishMessage("vasu");
		System.out.println("result: "+msg);
		
		System.out.println("---------------");
		String season=generator.showSeason("vasu");
		
		System.out.println("It's "+season+"Season");
		
		ctx.close();

	}

}
