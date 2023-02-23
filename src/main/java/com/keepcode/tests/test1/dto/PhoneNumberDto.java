package com.keepcode.tests.test1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumberDto {

    private String number;

    private String fullNumber;

    private CountryDto countryDto;

    public PhoneNumberDto(String number, CountryDto countryDto, String fullNumber) {
        this.number = number;
        this.countryDto = countryDto;
        this.fullNumber = fullNumber;
    }

}
