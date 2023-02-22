package com.keepcode.tests.test1.helper;

import com.keepcode.tests.test1.dto.CountryDto;
import com.keepcode.tests.test1.dto.PhoneNumberDto;
import com.keepcode.tests.test1.exception.ReadingException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Helper class for JSON
 */
public class JsonHelper {


    private JsonHelper() {
    }

    /**
     * Get list of properties from Json
     *
     * @param json     is json object with array property
     * @param property name of array property to get
     * @return list of JSONObject
     */
    public static List<JSONObject> getListOfArrayProperty(JSONObject json, String property) {
        List<JSONObject> result = new ArrayList<>();
        JSONArray objects = json.getJSONArray(property);
        for (Object o : objects) {
            result.add(new JSONObject(o.toString()));
        }
        return result;
    }

    /**
     * Convert InputStream to JSONObject
     *
     * @param inputStream json as stream
     * @return json from stream
     * @throws ReadingException if something wrong with reading
     */
    public static JSONObject getJsonFromInputStream(InputStream inputStream) {
        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
            for (char[] chars = new char[5000]; in.read(chars) != -1; chars = new char[5000]) {
                response.append(chars);
            }
        } catch (IOException e) {
            throw new ReadingException("Error while reading", e);
        }
        return new JSONObject(response.toString());
    }

    /**
     * Get date from json
     *
     * @param json      any json with date to get
     * @param property  name of date property
     * @param formatter specified date time formatter
     * @return date from json
     * @throws IllegalArgumentException if date by property doesn't exist
     */
    public static LocalDateTime getDateFromJson(JSONObject json, String property, DateTimeFormatter formatter) {
        String date = json.getString(property);
        if (Objects.isNull(date)) {
            throw new IllegalArgumentException("Date property not found");
        }
        return LocalDateTime.parse(date, formatter);
    }

    /**
     * Parse json from onlinesim api to PhoneNumber
     *
     * @param json json response from onlinesim api
     * @return phoneNumber from json
     */
    public static PhoneNumberDto parsePhoneNumbersFromOnlineSimApi(JSONObject json) {
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setCountryDto(new CountryDto(json.getInt("country"), json.getString("country_text")));
        phoneNumberDto.setNumber(json.getString("number"));
        phoneNumberDto.setDataHumans(json.getString("data_humans"));
        phoneNumberDto.setFullNumber(json.getString("full_number"));
        phoneNumberDto.setStatus(json.getString("status"));
        phoneNumberDto.setUpdatedAt(JsonHelper.getDateFromJson(json, "updated_at", OnlineSimApiHelper.ONLINE_SIM_API_DATA_FORMATTER));
        phoneNumberDto.setMaxDate(JsonHelper.getDateFromJson(json, "maxdate", OnlineSimApiHelper.ONLINE_SIM_API_DATA_FORMATTER));
        return phoneNumberDto;
    }

    /**
     * Parse json from onlinesim api to Country
     *
     * @param json json response from onlinesim api
     * @return country from json
     */
    public static CountryDto parseCountryFromOnlineSimApi(JSONObject json) {
        CountryDto countryDto = new CountryDto();
        countryDto.setCountryCode(json.getInt("country"));
        countryDto.setCountryName(json.getString("country_text"));
        return countryDto;
    }
}
