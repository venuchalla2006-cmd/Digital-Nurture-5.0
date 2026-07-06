package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - main");
        ApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
        
        // Execute simple hands-on tests on startup
        displayDate();
        displayCountry();
        displayCountries();
        
        LOGGER.info("END - main");
    }

    public static void displayDate() {
        LOGGER.info("START - displayDate");
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Error parsing date: {}", e.getMessage());
        }
        LOGGER.info("END - displayDate");
    }

    public static void displayCountry() {
        LOGGER.info("START - displayCountry");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Demonstrate Singleton Scope (Hands-on 5)
        Country country = context.getBean("in", Country.class);
        Country anotherCountry = context.getBean("in", Country.class);
        
        LOGGER.debug("Country: {}", country.toString());
        LOGGER.debug("Another Country reference: {}", anotherCountry.toString());
        LOGGER.info("END - displayCountry");
    }

    @SuppressWarnings("unchecked")
    public static void displayCountries() {
        LOGGER.info("START - displayCountries");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> list = context.getBean("countryList", ArrayList.class);
        LOGGER.debug("List of countries: {}", list);
        LOGGER.info("END - displayCountries");
    }
}
