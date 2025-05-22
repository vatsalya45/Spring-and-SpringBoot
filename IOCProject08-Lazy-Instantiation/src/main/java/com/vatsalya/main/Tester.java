package com.vatsalya.main;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vatsalya.config.AppConfig;
import com.vatsalya.sbeans.WishMessageGenrator;

public class Tester {
    public static void main(String[] args) {
    	
    	//Create IOC Container
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	//Calling by getBean()  
    	WishMessageGenrator w1 = ctx.getBean("wmg",WishMessageGenrator.class);
    	WishMessageGenrator w2 = ctx.getBean("wmg",WishMessageGenrator.class);
    	WishMessageGenrator w3 = ctx.getBean("wmg",WishMessageGenrator.class);
    	System.out.println(w1.hashCode()+">>>>"+w2.hashCode()+">>>>"+w3.hashCode());
    	
    	System.out.println("============================================");
    	
    	LocalDateTime ldt1 = ctx.getBean("ldt",LocalDateTime.class); 
    	LocalDateTime ldt2 = ctx.getBean("ldt",LocalDateTime.class);
    	System.out.println(ldt1.hashCode()+">>>>>"+ldt2.hashCode());
    	
    	System.out.println("============================================");
    	LocalDateTime ldt3 = ctx.getBean("ldt1",LocalDateTime.class); 
    	LocalDateTime ldt4 = ctx.getBean("ldt1",LocalDateTime.class); 
    	System.out.println(ldt3.hashCode()+">>>>>>"+ldt4.hashCode());
    	
    	//closing the IOC container
    	ctx.close();
    }
}
