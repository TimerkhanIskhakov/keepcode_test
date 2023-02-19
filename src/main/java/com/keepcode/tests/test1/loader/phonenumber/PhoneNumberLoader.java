package com.keepcode.tests.test1.loader.phonenumber;

import com.keepcode.tests.test1.dto.Country;
import com.keepcode.tests.test1.dto.PhoneNumber;

import java.util.List;

/**
 * Loader for phone numbers
 */
public interface PhoneNumberLoader {
    /**
     * Load phone numbers by specified country
     *
     * @param country specified country
     * @return list of phone numbers
     */
    List<PhoneNumber> loadFreeNumbersByCountry(Country country);
}
