package com.country.service;

import com.country.exception.CountryNotFoundException;
import com.country.model.Country;
import com.country.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public int getCitizens(String country) throws CountryNotFoundException {
        Optional<Country> countryByName = countryRepository.findByName(country);
        if (countryByName.isEmpty()) {
            throw new CountryNotFoundException("Country with name " + country + " does not exist in the database");
        }
        return countryByName.get().getPopulation();
    }
}
