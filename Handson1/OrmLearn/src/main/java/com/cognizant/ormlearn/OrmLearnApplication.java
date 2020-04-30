package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	@Autowired
	private static CountryService countryService;

	public static void main(String[] args) {

		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
/*Please do uncomment all the invokation to test methods
 */
 

//		testing get all countries::	
//		testGetAllCountries();
//		try {
//			getAllCountriesTest();
//		} catch (CountryNotFoundException e) {
//			System.out.println(e.getMessage());
//		}

//		testing Add Country::
//		try {
//			testAddCountry();
//		} catch (CountryNotFoundException e) {

//			System.out.println(e.getMessage());
//		}

//		testing Update Country::
//		testUpdateCountry();

//		testing Delete Country::
//		testDeleteCountry();
		
//		testing Name Match::
//		testNameMatch();

//		testing Name Match with Sort
//		testNameMatchWithSort();

	}

	private static void testGetAllCountries() {
		LOGGER.info("Start:: to test get all countries");
		List<Country> countries = null;
		countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
		// System.out.println(countries);
	}

	private static void getAllCountriesTest() throws CountryNotFoundException {
		LOGGER.info("Start:: to test validity of input country code");
		Country country = countryService.findCountryByCode("IN");

		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
		// System.out.println(country);
	}

	// test to add country::
	private static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start:: to test creation and saving object");
		Country country = new Country();
		country.setCode("WP");
		country.setName("Well Played");
		countryService.addCountry(country);
		Country countryrecieved = countryService.findCountryByCode("WP");
		LOGGER.debug("Country:{}", countryrecieved);
		LOGGER.info("End");
		// System.out.println(country);

	}

	private static void testUpdateCountry() {
		LOGGER.info("Start:: to test the Updated ");
		countryService.updateCountry("WP", "Name Changed");
		LOGGER.info("END");

	}

	private static void testDeleteCountry() {
		LOGGER.info("Start:: to test the DeleteCountry ");
		countryService.deleteCountry("WP");
		LOGGER.info("END");

	}

	private static void testNameMatch() {
		LOGGER.info("Start:: to test the Name Matching");
		List<Country> countries=countryService.getNameMatching("ou");
		for(Country c:countries)
		{
			System.out.println("\nCode :: "+c.getCode()+"\t\t\t\t\t\tName :: "+c.getName());
		}		LOGGER.info("END");
	}

	private static void testNameMatchWithSort() {
		LOGGER.info("Start:: to test the Name Matching");
		List<Country> countries=countryService.getNameMatchingSorted("ou");
		for(Country c:countries)
		{
			System.out.println("\nCode :: "+c.getCode()+"\t\t\t\t\t\tName :: "+c.getName());
		}
		LOGGER.info("END");
	}

	public void run(String... args) {

	}

}
