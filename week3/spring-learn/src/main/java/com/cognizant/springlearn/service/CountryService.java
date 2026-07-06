package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    
    private final List<Country> countries = new ArrayList<>();

    public CountryService() {
        LOGGER.info("START - Loading countryList from country.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<?> rawList = context.getBean("countryList", ArrayList.class);
        for (Object obj : rawList) {
            if (obj instanceof Country) {
                countries.add((Country) obj);
            }
        }
        LOGGER.debug("Countries loaded into service: {}", countries);
        LOGGER.info("END - Loading countryList");
    }

    public List<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries");
        LOGGER.info("END - getAllCountries");
        return countries;
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountry for code '{}'", code);
        Country found = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));
        LOGGER.debug("Found country: {}", found);
        LOGGER.info("END - getCountry");
        return found;
    }
}
