package com.keepcode.tests.test1.phonenumbers;

import com.keepcode.tests.test1.dto.Country;
import com.keepcode.tests.test1.dto.PhoneNumber;
import com.keepcode.tests.test1.helper.JsonHelper;
import com.keepcode.tests.test1.helper.OnlineSimApiHelper;
import com.keepcode.tests.test1.web.HttpsRequestJsonInvoker;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class for loading free phones numbers
 */
public class OnlineSimFreePhoneNumberLoader implements PhoneNumberLoader {

    public static final String GET_PHONE_LIST_URL = "https://onlinesim.ru/api/getFreePhoneList?country=";

    String numbersJsonProperty = "numbers";

    /**
     * Load free phone numbers by specified country
     *
     * @return free phone numbers by specified country
     * @throws IllegalArgumentException if specified country is null
     */
    @Override
    public List<PhoneNumber> loadFreeNumbersByCountry(Country country) {
        if (Objects.isNull(country)) {
            throw new IllegalArgumentException("Country can't be null");
        }
        JSONObject numberResponse = new HttpsRequestJsonInvoker(GET_PHONE_LIST_URL + country.getCountryCode()).invokeGet();
        OnlineSimApiHelper.checkResponse(numberResponse);
        return getNumbers(numberResponse, numbersJsonProperty);
    }

    private List<PhoneNumber> getNumbers(JSONObject response, String property) {
        return JsonHelper.getListOfArrayProperty(response, property).stream()
                .map(PhoneNumber::new)
                .collect(Collectors.toList());
    }
}
