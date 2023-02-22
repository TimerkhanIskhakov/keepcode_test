package com.keepcode.tests.test1.service.country;

import com.keepcode.tests.test1.dto.CountryDto;
import com.keepcode.tests.test1.loader.country.CountryLoader;

import java.util.List;

/**
 * Base implementation of CountryService
 */
public class CountryServiceImpl implements CountryService {

    private final CountryLoader countryLoader;

    public CountryServiceImpl(CountryLoader countryLoader) {
        this.countryLoader = countryLoader;
    }

    /**
     * Load countries via specified countryLoader
     *
     * @return list of countries
     */
    @Override
    public List<CountryDto> loadCountries() {
        return countryLoader.loadCountries();
    }
}
