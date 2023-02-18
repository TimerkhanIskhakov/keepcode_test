package com.keepcode.tests.test1.dto;

import lombok.Getter;
import org.json.JSONObject;

import java.util.Objects;

@Getter
public class Country {

    private int countryCode;

    private String countryName;

    public Country(int countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public Country(JSONObject country) {
        parseJson(country);
    }

    private void parseJson(JSONObject country) {
        this.countryCode = country.getInt("country");
        this.countryName = country.getString("country_text");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country1 = (Country) o;
        return countryCode == country1.countryCode && Objects.equals(countryName, country1.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, countryName);
    }

}
