package com.kaczmarm.Cars.service;

import com.kaczmarm.Cars.model.UserView;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    public static final String BAD_INFORMATION = "INCORRECT INFORMATION PROVIDED";
    private final String apiURL = "https://user-crud-hrk.herokuapp.com/users";

    public UserView getUserInformation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String apiURLWithId = apiURL + id;
        UserView response = restTemplate.getForObject(apiURLWithId, UserView.class);

        return response;

    }

}
