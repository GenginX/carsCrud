package com.kaczmarm.Cars.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    private final String apiURL = "http://localhost:8080/user/}";

    public String getUserInformation(String information, Long id) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        JSONObject responseJson = restTemplate.getForObject(apiURL + id, JSONObject.class);
        return responseJson.getString(information);
    }

}
