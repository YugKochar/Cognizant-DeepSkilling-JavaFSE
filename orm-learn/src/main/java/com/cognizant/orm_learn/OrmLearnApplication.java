package com.cognizant.orm_learn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.StockExchange;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.StockExchangeService;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	private static StockExchangeService stockExchangeService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");

		countryService = context.getBean(CountryService.class);
		stockExchangeService = context.getBean(StockExchangeService.class);

		// --- Run Feature Tests ---
		testSearchCountriesContaining();
		testSearchCountriesStartingWith();
		testGetAllStockExchangesRelationship();
	}

	private static void testSearchCountriesContaining() {
		LOGGER.info("--- Testing Query Method: Containing 'in' Sorted ---");
		List<Country> countries = countryService.searchCountriesContainingSorted("in", "name");
		LOGGER.debug("Countries containing 'in': {}", countries);
	}

	private static void testSearchCountriesStartingWith() {
		LOGGER.info("--- Testing Query Method: Starting With 'Un' ---");
		List<Country> countries = countryService.searchCountriesStartingWith("Un");
		LOGGER.debug("Countries starting with 'Un': {}", countries);
	}

	private static void testGetAllStockExchangesRelationship() {
		LOGGER.info("--- Testing O/R Mapping: ManyToOne Relationship ---");
		List<StockExchange> exchanges = stockExchangeService.getAllStockExchanges();
		for (StockExchange se : exchanges) {
			LOGGER.debug("Exchange: {} belongs to Country: {}", se.getName(), se.getCountry().getName());
		}
	}
}