package com.keepcode.tests.test1;

import com.keepcode.tests.test1.dto.CountryDto;
import com.keepcode.tests.test1.dto.PhoneNumberDto;
import com.keepcode.tests.test1.loader.country.OnlineSimCountryLoader;
import com.keepcode.tests.test1.loader.phonenumber.OnlineSimFreePhoneNumberLoader;
import com.keepcode.tests.test1.service.country.CountryService;
import com.keepcode.tests.test1.service.country.CountryServiceImpl;
import com.keepcode.tests.test1.service.phonenumber.PhoneNumberService;
import com.keepcode.tests.test1.service.phonenumber.PhoneNumberServiceImpl;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            CountryService countryService =
                    new CountryServiceImpl(new OnlineSimCountryLoader());
            PhoneNumberService phoneService =
                    new PhoneNumberServiceImpl(new OnlineSimFreePhoneNumberLoader());

            Map<CountryDto, List<PhoneNumberDto>> countryToNumbers =
                    phoneService.loadPhoneNumbers(countryService.loadCountries());

            phoneService.writePhoneNumbersToConsole(countryToNumbers);
        } catch (Exception e) {
            //better write to log
            e.printStackTrace();
        }
    }

}
