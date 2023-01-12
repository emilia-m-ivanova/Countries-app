package com.country.repository;

import com.country.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,String> {
    Optional<Country> findByName(String name);

    List<Country> findAll();

}
