package com.keepcode.tests.test1.loader.phonenumber;

import com.keepcode.tests.test1.dto.CountryDto;
import com.keepcode.tests.test1.dto.PhoneNumberDto;

import java.util.List;

/**
 * Loader for phone numbers
 */
public interface PhoneNumberLoader {
    /**
     * Load phone numbers by specified country
     *
     * @param countryDto specified country
     * @return list of phone numbers
     */
    List<PhoneNumberDto> loadFreeNumbersByCountry(CountryDto countryDto);
}
