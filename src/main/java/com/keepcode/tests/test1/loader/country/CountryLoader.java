package com.keepcode.tests.test1.loader.country;

import com.keepcode.tests.test1.dto.CountryDto;

import java.util.List;

/**
 * Loader for countries
 */
public interface CountryLoader {

    /**
     * Load countries
     *
     * @return list of countries
     */
    List<CountryDto> loadCountries();
}
