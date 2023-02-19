package com.keepcode.tests.test1.helper;

import com.keepcode.tests.test1.exception.ResponseException;
import org.json.JSONObject;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * Helper class for onlinesim.ru/api
 */
public class OnlineSimApiHelper {

    private static final String RESPONSE_CODE_OK = "1";

    private static final String RESPONSE_CODE_JSON_PROPERTY = "response";

    public static final DateTimeFormatter ONLINE_SIM_API_DATA_FORMATTER =
            new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss").toFormatter();

    private OnlineSimApiHelper() {
    }

    /**
     * Check if response code is error
     *
     * @param response response from onlinesim.ru/api
     * @throws ResponseException if response code is not equal to RESPONSE_CODE_JSON_PROPERTY
     */
    public static void checkResponse(JSONObject response) {
        Object jsonObject = response.get(RESPONSE_CODE_JSON_PROPERTY);
        String responseCode = jsonObject.toString();
        if (!responseCode.equals(RESPONSE_CODE_OK)) {
            throw new ResponseException("Response error: " + responseCode);
        }
    }
}
