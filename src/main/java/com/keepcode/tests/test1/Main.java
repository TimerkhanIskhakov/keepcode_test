package com.keepcode.tests.test1;

import com.keepcode.tests.test1.dto.Country;
import com.keepcode.tests.test1.dto.PhoneNumber;
import com.keepcode.tests.test1.loader.country.CountryLoader;
import com.keepcode.tests.test1.loader.country.OnlineSimCountryLoader;
import com.keepcode.tests.test1.loader.phonenumber.OnlineSimFreePhoneNumberLoader;
import com.keepcode.tests.test1.loader.phonenumber.PhoneNumberLoader;
import com.keepcode.tests.test1.writer.phonenumber.PhoneNumbersWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            CountryLoader countryLoader = new OnlineSimCountryLoader();
            List<Country> countries = countryLoader.loadCountries();
            Map<Country, List<PhoneNumber>> countryToNumbers = new HashMap<>();

            for (Country country : countries) {
                PhoneNumberLoader numbersLoader = new OnlineSimFreePhoneNumberLoader();
                List<PhoneNumber> numbers = numbersLoader.loadFreeNumbersByCountry(country);
                countryToNumbers.put(country, numbers);
            }

            PhoneNumbersWriter numbersWriter = new PhoneNumbersWriter(countryToNumbers);
            numbersWriter.writeNumbersToConsole();
        } catch (Exception e) {
            //better write to log
            e.printStackTrace();
        }
    }

}
