package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting OrmLearnApplication");
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("OrmLearnApplication started successfully");
    }

    @Bean
    public CommandLineRunner demo(CountryService countryService) {
        return (args) -> {
            LOGGER.info("Inside CommandLineRunner - starting test sequences");
            
            // 1. Seed database with some countries for testing
            try {
                countryService.addCountry(new Country("IN", "India"));
                countryService.addCountry(new Country("US", "United States"));
                countryService.addCountry(new Country("FR", "France"));
                countryService.addCountry(new Country("AF", "Afghanistan"));
                LOGGER.info("Seeded initial countries.");
            } catch (Exception e) {
                LOGGER.warn("Seed data already present or error during seeding: {}", e.getMessage());
            }

            // 2. Test Get All Countries (Hands-on 1)
            testGetAllCountries(countryService);

            // 3. Test Find Country by Code (Hands-on 6)
            testFindCountryByCode(countryService, "IN");
            testFindCountryByCode(countryService, "XX"); // Should throw exception

            // 4. Test Add Country (Hands-on 7)
            testAddCountry(countryService);

            // 5. Test Update Country (Hands-on 8)
            testUpdateCountry(countryService);

            // 6. Test Delete Country (Hands-on 9)
            testDeleteCountry(countryService);

            // 7. Test Find Countries by Partial Name (Hands-on 5)
            testFindCountriesByNamePart(countryService, "an");

            LOGGER.info("All orm-learn tests executed successfully");
        };
    }

    private static void testGetAllCountries(CountryService countryService) {
        LOGGER.info("START - testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("END - testGetAllCountries (Size: {})", countries.size());
    }

    private static void testFindCountryByCode(CountryService countryService, String code) {
        LOGGER.info("START - testFindCountryByCode for '{}'", code);
        try {
            Country country = countryService.findCountryByCode(code);
            LOGGER.debug("country={}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
        LOGGER.info("END - testFindCountryByCode");
    }

    private static void testAddCountry(CountryService countryService) {
        LOGGER.info("START - testAddCountry");
        Country newCountry = new Country("OU", "Our Land");
        countryService.addCountry(newCountry);
        try {
            Country fetched = countryService.findCountryByCode("OU");
            LOGGER.debug("Added country fetched successfully: {}", fetched);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to find added country: {}", e.getMessage());
        }
        LOGGER.info("END - testAddCountry");
    }

    private static void testUpdateCountry(CountryService countryService) {
        LOGGER.info("START - testUpdateCountry");
        try {
            LOGGER.info("Updating country 'OU' to name 'Our Land Updated'");
            countryService.updateCountry("OU", "Our Land Updated");
            Country updated = countryService.findCountryByCode("OU");
            LOGGER.debug("Updated country: {}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to update country: {}", e.getMessage());
        }
        LOGGER.info("END - testUpdateCountry");
    }

    private static void testDeleteCountry(CountryService countryService) {
        LOGGER.info("START - testDeleteCountry");
        LOGGER.info("Deleting country 'OU'");
        countryService.deleteCountry("OU");
        try {
            countryService.findCountryByCode("OU");
            LOGGER.error("Country 'OU' was not deleted!");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Country 'OU' deleted successfully (Confirmed: {})", e.getMessage());
        }
        LOGGER.info("END - testDeleteCountry");
    }

    private static void testFindCountriesByNamePart(CountryService countryService, String namePart) {
        LOGGER.info("START - testFindCountriesByNamePart for '{}'", namePart);
        List<Country> matchingCountries = countryService.findCountriesByNamePart(namePart);
        LOGGER.debug("Matching countries: {}", matchingCountries);
        LOGGER.info("END - testFindCountriesByNamePart");
    }
}
