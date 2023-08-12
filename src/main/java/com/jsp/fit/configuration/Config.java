package com.jsp.fit.configuration;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.jsp.fit")
public class Config {

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		
		return Persistence.createEntityManagerFactory("sujit");
	}
	
	
	
}
