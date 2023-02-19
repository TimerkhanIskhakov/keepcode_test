package com.keepcode.tests.test1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Country {

    private Integer countryCode;

    private String countryName;

    public Country(int countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public Country() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country1 = (Country) o;
        return Objects.equals(countryCode, country1.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode);
    }

}
