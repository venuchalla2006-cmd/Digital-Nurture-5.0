package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Get all countries (Hands-on 1, step 125-132)
    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Find country by code (Hands-on 6, step 487-498)
    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + countryCode);
        }
        return result.get();
    }

    // Add country (Hands-on 7, step 508-513)
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // Update country name (Hands-on 8, step 521-524)
    @Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }
        Country country = result.get();
        country.setName(newName);
        countryRepository.save(country);
    }

    // Delete country (Hands-on 9, step 529-530)
    @Transactional
    public void deleteCountry(String countryCode) {
        countryRepository.deleteById(countryCode);
    }

    // Find country by partial name (Hands-on 5, step 223)
    @Transactional(readOnly = true)
    public List<Country> findCountriesByNamePart(String namePart) {
        return countryRepository.findByNameContainingOrderByNameAsc(namePart);
    }
}
