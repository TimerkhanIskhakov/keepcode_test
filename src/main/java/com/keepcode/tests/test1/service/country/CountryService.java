package com.keepcode.tests.test1.service.country;

import com.keepcode.tests.test1.dto.CountryDto;

import java.util.List;

/**
 * Service for work with countries
 */
public interface CountryService {

    /**
     * Load countries
     *
     * @return list of countries
     */
    List<CountryDto> loadCountries();
}
