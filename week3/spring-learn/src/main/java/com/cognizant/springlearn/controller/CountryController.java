package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    // Get India Country Details (Hands-on 2, step 73)
    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);
        LOGGER.debug("Country loaded: {}", country);
        LOGGER.info("END - getCountryIndia");
        return country;
    }

    // Get All Countries (Hands-on 2, step 83)
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries REST");
        List<Country> list = countryService.getAllCountries();
        LOGGER.debug("Countries returned: {}", list);
        LOGGER.info("END - getAllCountries REST");
        return list;
    }

    // Get Country by Code (Hands-on 2, step 90)
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountry REST for code '{}'", code);
        Country country = countryService.getCountry(code);
        LOGGER.debug("Country found: {}", country);
        LOGGER.info("END - getCountry REST");
        return country;
    }

    // Add Country (Hands-on Docx 4)
    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("START - addCountry REST");
        LOGGER.debug("Adding country: {}", country);
        countryService.addCountry(country);
        LOGGER.info("END - addCountry REST");
        return country;
    }
}
