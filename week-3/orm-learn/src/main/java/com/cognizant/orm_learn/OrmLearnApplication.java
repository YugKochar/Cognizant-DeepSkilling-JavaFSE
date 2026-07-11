package com.cognizant.orm_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.orm_learn.model.Country;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");

		// Execute the XML parsing test
		displayCountry();
	}

	public static void displayCountry() {
		LOGGER.info("START");

		// Load the XML configuration file from the classpath
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		// Retrieve the bean using its ID definition
		Country country = context.getBean("country", Country.class);

		// Verify bean extraction via debug logs
		LOGGER.debug("Country : {}", country.toString());

		LOGGER.info("END");
	}
}