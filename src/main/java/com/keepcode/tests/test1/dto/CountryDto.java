package com.keepcode.tests.test1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class CountryDto {

    private Integer countryCode;

    private String countryName;

    public CountryDto(int countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public CountryDto() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto countryDto1 = (CountryDto) o;
        return Objects.equals(countryCode, countryDto1.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode);
    }

}
