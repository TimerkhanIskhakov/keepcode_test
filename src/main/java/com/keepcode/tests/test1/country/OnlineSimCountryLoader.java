package com.keepcode.tests.test1.country;

import com.keepcode.tests.test1.dto.Country;
import com.keepcode.tests.test1.helper.JsonHelper;
import com.keepcode.tests.test1.helper.OnlineSimApiHelper;
import com.keepcode.tests.test1.web.HttpsRequestJsonInvoker;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Country loader from Onlinesim API
 */
public class OnlineSimCountryLoader implements CountryLoader {

    public static final String GET_COUNTRY_URL = "https://onlinesim.ru/api/getFreeCountryList";

    String countriesJsonProperty = "countries";

    /**
     * Load countries from onlinesim api
     * @return list of countries
     */
    @Override
    public List<Country> loadCountries() {
        JSONObject countryResponse = new HttpsRequestJsonInvoker(GET_COUNTRY_URL).invokeGet();
        OnlineSimApiHelper.checkResponse(countryResponse);
        return getCountries(countryResponse, countriesJsonProperty);
    }

    private List<Country> getCountries(JSONObject response, String property) {
        return JsonHelper.getListOfArrayProperty(response, property).stream()
                .map(Country::new)
                .collect(Collectors.toList());
    }
}
