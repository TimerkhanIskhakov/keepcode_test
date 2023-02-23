package com.keepcode.tests.test1.loader.phonenumber;

import com.keepcode.tests.test1.dto.CountryDto;
import com.keepcode.tests.test1.dto.OnlineSimPhoneNumberDto;
import com.keepcode.tests.test1.dto.PhoneNumberDto;
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
     *
     * @return list of free phone numbers
     */
    @Override
    public List<PhoneNumberDto> loadFreeNumbersByCountry(CountryDto countryDto) {
        JSONObject numberResponse;
        if (Objects.isNull(countryDto) || Objects.isNull(countryDto.getCountryCode())) {
            numberResponse = new HttpsRequestJsonInvoker(GET_ALL_PHONES_URL).invokeGet();
        } else {
            numberResponse = new HttpsRequestJsonInvoker(GET_PHONE_LIST_BY_COUNTRY_URL + countryDto.getCountryCode()).invokeGet();
        }
        OnlineSimApiHelper.checkResponse(numberResponse);
        return getNumbers(numberResponse, numbersJsonProperty);
    }

    private List<PhoneNumberDto> getNumbers(JSONObject response, String property) {
        return JsonHelper.getListOfArrayProperty(response, property).stream()
                .map(OnlineSimPhoneNumberDto::new)
                .collect(Collectors.toList());
    }
}
