package com.keepcode.tests.test1.service.phonenumber;

import com.keepcode.tests.test1.dto.CountryDto;
import com.keepcode.tests.test1.dto.PhoneNumberDto;

import java.util.List;
import java.util.Map;

/**
 * Service for work with phone numbers
 */
public interface PhoneNumberService {

    /**
     * Load phone numbers by specified country
     *
     * @param countryDto is specified country
     * @return list of phone numbers
     */
    List<PhoneNumberDto> loadPhoneNumbers(CountryDto countryDto);

    /**
     * Load phone numbers by list of specified countries
     *
     * @param countries list of specified countries
     * @return map as countries to phone numbers
     */
    Map<CountryDto, List<PhoneNumberDto>> loadPhoneNumbers(List<CountryDto> countries);

    /**
     * Write phone numbers to console
     *
     * @param countryToNumbers map as countries to phone numbers to write
     */
    void writePhoneNumbersToConsole(Map<CountryDto, List<PhoneNumberDto>> countryToNumbers);

}
