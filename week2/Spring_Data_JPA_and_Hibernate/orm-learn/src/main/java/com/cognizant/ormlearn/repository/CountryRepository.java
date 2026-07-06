package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    
    // Derived query method to find countries matching a partial name (Hands-on 5)
    List<Country> findByNameContaining(String namePart);
    
    // Derived query method to find countries matching a partial name sorted by name (Hands-on 5)
    List<Country> findByNameContainingOrderByNameAsc(String namePart);
}
