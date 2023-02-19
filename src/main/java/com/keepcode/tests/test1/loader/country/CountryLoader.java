package com.keepcode.tests.test1.loader.country;

import com.keepcode.tests.test1.dto.Country;

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
    List<Country> loadCountries();
}
