package com.keepcode.tests.test1.dto;

import org.json.JSONObject;

public class OnlineSimCountryDto extends CountryDto {

    public OnlineSimCountryDto(JSONObject json) {
        super(json.getInt("country"), json.getString("country_text"));
    }
}
