package com.tcjbeckett.CodewarsProject.services;

import com.tcjbeckett.CodewarsProject.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Component
public class CodeWarsApiService {

    private static final String API_BASE_URL = "https://www.codewars.com/api/v1/users/";

    private RestTemplate restTemplate;

    public CodeWarsApiService(){
        this.restTemplate = new RestTemplate();
    }

    public User getUser(String userID){
        String url = API_BASE_URL + userID;
        User user = restTemplate.getForObject(url, User.class);

        return user;
    }
}
