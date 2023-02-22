package com.keepcode.tests.test1.writer.phonenumber;

import com.keepcode.tests.test1.dto.CountryDto;
import com.keepcode.tests.test1.dto.PhoneNumberDto;

import java.util.List;
import java.util.Map;

/**
 * Class for writing phone numbers
 */
public class PhoneNumbersWriter {

    Map<CountryDto, List<PhoneNumberDto>> countryToNumbers;

    public PhoneNumbersWriter(Map<CountryDto, List<PhoneNumberDto>> countryToNumbers) {
        this.countryToNumbers = countryToNumbers;
    }

    /**
     * Write phone numbers in console
     */
    public void writeNumbersToConsole() {
        for (Map.Entry<CountryDto, List<PhoneNumberDto>> entry : countryToNumbers.entrySet()) {
            StringBuilder result = new StringBuilder();
            result.append("Free phone numbers for country: ")
                    .append(entry.getKey().getCountryName())
                    .append(System.lineSeparator());
            for (PhoneNumberDto number : entry.getValue()) {
                result.append(number.getFullNumber())
                        .append(System.lineSeparator());
            }
            System.out.println(result);
        }
    }
}
