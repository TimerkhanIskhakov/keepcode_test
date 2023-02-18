package com.keepcode.tests.test1.dto;

import lombok.Getter;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Getter
public class PhoneNumber {

    private String phoneNumber;

    private Country country;

    private LocalDateTime updatedAt;

    private String dataHumans;

    private String fullNumber;

    private LocalDateTime maxDate;

    private String status;

    public PhoneNumber(JSONObject number) {
        parseJson(number);
    }

    private void parseJson(JSONObject number) {
        this.country = new Country(number.getInt("country"), number.getString("country_text"));
        this.phoneNumber = number.getString("number");
        this.dataHumans = number.getString("data_humans");
        this.fullNumber = number.getString("full_number");
        this.status = number.getString("status");
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss").toFormatter();
        this.updatedAt = LocalDateTime.parse(number.getString("updated_at"),
                formatter);
        this.maxDate = LocalDateTime.parse(number.getString("maxdate"), formatter);
    }
}
