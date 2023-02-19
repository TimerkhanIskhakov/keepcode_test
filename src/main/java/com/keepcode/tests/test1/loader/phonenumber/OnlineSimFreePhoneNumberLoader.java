package com.keepcode.tests.test1.loader.phonenumber;

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

    public static final String GET_PHONE_LIST_BY_COUNTRY_URL = "https://onlinesim.ru/api/getFreePhoneList?country=";

    public static final String GET_ALL_PHONES_URL = "https://onlinesim.ru/api/getFreePhoneList";

    String numbersJsonProperty = "numbers";

    /**
     * Load free phone numbers by specified country or all phones for all countries if country isn't specified
     * @return list of free phone numbers
     */
    @Override
    public List<PhoneNumber> loadFreeNumbersByCountry(Country country) {
        JSONObject numberResponse;
        if (Objects.isNull(country) || Objects.isNull(country.getCountryCode())) {
            numberResponse = new HttpsRequestJsonInvoker(GET_ALL_PHONES_URL).invokeGet();
        } else {
            numberResponse = new HttpsRequestJsonInvoker(GET_PHONE_LIST_BY_COUNTRY_URL + country.getCountryCode()).invokeGet();
        }
        OnlineSimApiHelper.checkResponse(numberResponse);
        return getNumbers(numberResponse, numbersJsonProperty);
    }

    private List<PhoneNumber> getNumbers(JSONObject response, String property) {
        return JsonHelper.getListOfArrayProperty(response, property).stream()
                .map(JsonHelper::parsePhoneNumbersFromOnlineSimApi)
                .collect(Collectors.toList());
    }
}
