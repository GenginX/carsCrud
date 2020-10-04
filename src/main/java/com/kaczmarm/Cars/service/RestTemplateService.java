package com.kaczmarm.Cars.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    private final String apiURL = "";

    public String getUserInformation(String information) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        JSONObject responseJson = restTemplate.getForObject(apiURL, JSONObject.class);
        return responseJson.getString(information);
    }

}
