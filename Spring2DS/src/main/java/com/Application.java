package com;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.service.Cashier;
import com.service.EmployeeService;

@SpringBootApplication
@EnableAutoConfiguration (exclude = {  DataSourceAutoConfiguration.class })
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		
		log.info("Starting Application................");
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		List<String> isbn = Arrays.asList(new String[]{"0001","0002"});
		
		Cashier cashier = ctx.getBean(Cashier.class);
		cashier.checkout(isbn, "user1");
		
		EmployeeService empService = ctx.getBean(EmployeeService.class);
		empService.getEmployees();
		

	}

}

