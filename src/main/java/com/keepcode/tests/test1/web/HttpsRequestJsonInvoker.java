package com.keepcode.tests.test1.web;

import com.keepcode.tests.test1.exception.RequestException;
import com.keepcode.tests.test1.exception.ResponseException;
import com.keepcode.tests.test1.helper.JsonHelper;
import lombok.Setter;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class for https requests
 */
public class HttpsRequestJsonInvoker {

    @Setter
    private URL url;

    public HttpsRequestJsonInvoker(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new RequestException("Error while creating RequestInvoker. Url: " + url, e);
        }
    }

    /**
     * Invoke GET request on @url
     * @return response as Json
     * @throws RequestException if something went wrong while request
     * @throws ResponseException if response code is not HttpURLConnection.HTTP_OK
     */
    public JSONObject invokeGet() {
        try {
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return JsonHelper.getJsonFromInputStream(connection.getInputStream());
            } else {
                throw new ResponseException("Response code " + responseCode);
            }
        } catch (IOException e) {
            throw new RequestException("Error while invoke request. Url: " + url.toString(), e);
        }
    }
}
