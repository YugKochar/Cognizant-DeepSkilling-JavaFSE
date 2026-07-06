package com.cognizant.orm_learn.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.orm_learn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Query Method 1: Find countries containing a specific text segment in their name
    List<Country> findByNameContaining(String text);

    // Query Method 2: Find countries containing text sorted dynamically
    List<Country> findByNameContaining(String text, Sort sort);

    // Query Method 3: Find countries matching starting letters alphabet pattern
    List<Country> findByNameStartingWith(String prefix);
}