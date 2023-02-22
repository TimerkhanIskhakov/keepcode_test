package com.keepcode.tests.test1.service.phonenumber;

import com.keepcode.tests.test1.dto.CountryDto;
import com.keepcode.tests.test1.dto.PhoneNumberDto;
import com.keepcode.tests.test1.loader.phonenumber.PhoneNumberLoader;
import com.keepcode.tests.test1.writer.phonenumber.PhoneNumbersWriter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Base implementation of PhoneNumberService
 */
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private PhoneNumberLoader numbersLoader;

    public PhoneNumberServiceImpl(PhoneNumberLoader numbersLoader) {
        this.numbersLoader = numbersLoader;
    }

    /**
     * Load phone numbers by specified country via specified PhoneNumberLoader
     *
     * @param countryDto is specified country
     * @return list of phone numbers
     */
    @Override
    public List<PhoneNumberDto> loadPhoneNumbers(CountryDto countryDto) {
        return numbersLoader.loadFreeNumbersByCountry(countryDto);
    }

    /**
     * Load phone numbers by list of specified countries
     *
     * @param countries list of specified countries
     * @return map as countries to phone numbers
     */
    @Override
    public Map<CountryDto, List<PhoneNumberDto>> loadPhoneNumbers(List<CountryDto> countries) {
        return countries.stream()
                .collect(Collectors.toMap(countryDto -> countryDto, this::loadPhoneNumbers));
    }

    /**
     * Write phone numbers to console via PhoneNumbersWriter
     *
     * @param countryToNumbers map as countries to phone numbers to write
     */
    @Override
    public void writePhoneNumbersToConsole(Map<CountryDto, List<PhoneNumberDto>> countryToNumbers) {
        PhoneNumbersWriter numbersWriter = new PhoneNumbersWriter(countryToNumbers);
        numbersWriter.writeNumbersToConsole();
    }

}
