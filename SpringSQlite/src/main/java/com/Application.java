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

import com.guru.service.EmployeeService;

@SpringBootApplication
@EnableAutoConfiguration (exclude = {  DataSourceAutoConfiguration.class })
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

		public static void main(String[] args) {
		
		log.info("Starting Application................");
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		List<String> isbn = Arrays.asList(new String[]{"0001","0002"});
		
		EmployeeService empService = ctx.getBean(EmployeeService.class);
		System.out.println("Employee Value :: "+empService.fetchEmployee(1L));
		
		/*Cashier cashier = ctx.getBean(Cashier.class);
		cashier.checkout(isbn, "user1");*/
		
		/*StockService iStockService = ctx.getBean(StockService.class);
		System.out.println("IStockService :: "+iStockService.findAll());
		
		BookingService bookingService = ctx.getBean(BookingService.class);
		bookingService.book("Alice", "Bob", "Carol");
		Assert.assertEquals("First booking should work with no problem", 3,
				bookingService.findAllBookings().size());

		try {
			bookingService.book("Chris", "Samuel");
		}
		catch (RuntimeException e) {
			log.info("v--- The following exception is expect because 'Samuel' is too big for the DB ---v");
			log.error(e.getMessage());
		}

		for (String person : bookingService.findAllBookings()) {
			log.info("So far, " + person + " is booked.");
		}
		log.info("You shouldn't see Chris or Samuel. Samuel violated DB constraints, and Chris was rolled back in the same TX");
		Assert.assertEquals("'Samuel' should have triggered a rollback", 3,
				bookingService.findAllBookings().size());

		try {
			bookingService.book("Buddy", null);
		}
		catch (RuntimeException e) {
			log.info("v--- The following exception is expect because null is not valid for the DB ---v");
			log.error(e.getMessage());
		}

		for (String person : bookingService.findAllBookings()) {
			log.info("So far, " + person + " is booked.");
		}
		log.info("You shouldn't see Buddy or null. null violated DB constraints, and Buddy was rolled back in the same TX");
		Assert.assertEquals("'null' should have triggered a rollback", 3, bookingService
				.findAllBookings().size());*/

	}

}

