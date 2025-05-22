package com.vatsalya.IOCProject4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vatsalya.cfgs.AppConfig;
import com.vatsalya.sbeans.*;

public class Tester 
{
    public static void main( String[] args )
    {
    	
    	//Creating the IOC Container
    	//Bring XML also (AppConfig.class)
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
       
        //Get target spring bean class
        FlipKart fk = ctx.getBean("fk",FlipKart.class);
        
        //Invoke the business method
        String resultMsg = fk.shopping(new String[] {"Shirt","Pant","jacket"},new float[] { 800.0f, 1200.0f,1500.90f}); 
        System.out.println(resultMsg);
        ctx.close();
        //End of Application
    }
}
