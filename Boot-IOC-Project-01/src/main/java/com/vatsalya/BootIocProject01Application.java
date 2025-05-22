//Main Class
package com.vatsalya;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.vatsalya.sbeans.SeasonFinder;

@SpringBootApplication
public class BootIocProject01Application {

    @Bean(name = "ld")
    LocalDate createDate() {
		return LocalDate.now();
	}
	public static void main(String[] args) {
		
		//Getting IOC Container  
		ApplicationContext ctx = SpringApplication.run(BootIocProject01Application.class, args);
		
		//Getting Target Spring Bean
		SeasonFinder finder = ctx.getBean("sf",SeasonFinder.class);
		
		//Invoking the Business Method 
		String seasonName = finder.findSeason();
		
		System.out.println("Season Name = "+seasonName);
		
		//Close the  IOC Container
		((ConfigurableApplicationContext)ctx).close();
		
	}

}







