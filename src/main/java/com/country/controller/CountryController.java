package com.country.controller;

import com.country.exception.CountryNotFoundException;
import com.country.model.Country;
import com.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country-controller")
public class CountryController {

  @Autowired
  private CountryService countryService;

  @GetMapping
  public ResponseEntity<List<Country>> getAllCountries() {
    return ResponseEntity.ok(countryService.getAllCountries());
  }

  @PostMapping
  public ResponseEntity<Object> getCountryPopulation(@RequestBody PopulationRequest request) {
    try {
      return ResponseEntity.ok(countryService.getCitizens(request.getCountry()));
    } catch (CountryNotFoundException ex){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(ex.getMessage());
    }
  }

}
