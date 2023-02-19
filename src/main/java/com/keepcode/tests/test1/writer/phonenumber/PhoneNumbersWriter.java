package com.keepcode.tests.test1.writer.phonenumber;

import com.keepcode.tests.test1.dto.Country;
import com.keepcode.tests.test1.dto.PhoneNumber;

import java.util.List;
import java.util.Map;

/**
 * Class for writing phone numbers
 */
public class PhoneNumbersWriter {

    Map<Country, List<PhoneNumber>> countryToNumbers;

    public PhoneNumbersWriter(Map<Country, List<PhoneNumber>> countryToNumbers) {
        this.countryToNumbers = countryToNumbers;
    }

    /**
     * Write phone numbers in console
     */
    public void writeNumbersToConsole() {
        for (Map.Entry<Country, List<PhoneNumber>> entry : countryToNumbers.entrySet()) {
            StringBuilder result = new StringBuilder();
            result.append("Free phone numbers for country: ")
                    .append(entry.getKey().getCountryName())
                    .append(System.lineSeparator());
            for (PhoneNumber number : entry.getValue()) {
                result.append(number.getFullNumber())
                        .append(System.lineSeparator());
            }
            System.out.println(result);
        }
    }
}
