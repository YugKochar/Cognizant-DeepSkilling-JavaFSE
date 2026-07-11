package com.cognizant.orm_learn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesContaining(String text) {
        return countryRepository.findByNameContaining(text);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesContainingSorted(String text, String sortByProperty) {
        return countryRepository.findByNameContaining(text, Sort.by(Sort.Direction.ASC, sortByProperty));
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}