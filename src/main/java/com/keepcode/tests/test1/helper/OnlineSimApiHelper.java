package com.keepcode.tests.test1.helper;

import com.keepcode.tests.test1.exception.ResponseException;
import org.json.JSONObject;

/**
 * Helper class for onlinesim.ru/api
 */
public class OnlineSimApiHelper {

    private static final int RESPONSE_CODE_OK = 1;

    private static final String RESPONSE_CODE_JSON_PROPERTY = "response";

    private OnlineSimApiHelper() {
    }

    /**
     * Check if response code is error
     * @param response response from onlinesim.ru/api
     * @throws ResponseException if response code is not equal to RESPONSE_CODE_JSON_PROPERTY
     */
    public static void checkResponse(JSONObject response) {
        int responseCode = response.getInt(RESPONSE_CODE_JSON_PROPERTY);
        if (responseCode != RESPONSE_CODE_OK) {
            throw new ResponseException("Response code is: " + responseCode);
        }
    }
}
