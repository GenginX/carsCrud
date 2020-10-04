package com.kaczmarm.Cars.service;

import com.kaczmarm.Cars.exception.IncorrectInformationException;
import com.kaczmarm.Cars.model.UserView;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    public static final String BAD_INFORMATION = "INCORRECT INFORMATION PROVIDED";
    private final String apiURL = "http://localhost:8080/users/";

    public UserView getUserInformation(Long id) throws IncorrectInformationException {
        RestTemplate restTemplate = new RestTemplate();
        String apiURLWithId = apiURL + id;
        UserView response = restTemplate.getForObject(apiURLWithId, UserView.class);
//        switch (information.toLowerCase()){
//            case "age":
//                int age = response.getAge();
//                return String.valueOf(age);
//            case "name":
//                String name = response.getName();
//                return name;
//            case "surname":
//                String surname = response.getSurname();
//                return surname;
//
//        }
        return response;

    }

}
