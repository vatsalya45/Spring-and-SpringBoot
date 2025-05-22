package com.vatsalya.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vatsalya.config.AppConfig;
import com.vatsalya.sbeans.WishMessageGenerator;

public class Tester {
    
	public static void main(String[] args) 
    {
        //Create IOC container 
    	@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	//get Spring bean class object 
    	WishMessageGenerator w1 = ctx.getBean("wmg",WishMessageGenerator.class);
    	WishMessageGenerator w2 = ctx.getBean("wmg",WishMessageGenerator.class);
    	WishMessageGenerator w3 = ctx.getBean("wmg",WishMessageGenerator.class);
    	
    	System.out.println(w1.hashCode()+".."+w2.hashCode()+".."+w3.hashCode());
    }
    
}
