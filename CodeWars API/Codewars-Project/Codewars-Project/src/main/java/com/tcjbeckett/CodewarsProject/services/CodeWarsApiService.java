package com.tcjbeckett.CodewarsProject.services;

import com.tcjbeckett.CodewarsProject.model.CodewarsApiGetResponse;
import com.tcjbeckett.CodewarsProject.model.User;
import com.tcjbeckett.CodewarsProject.model.UserListItems;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public User getOneUser(String userID){
        User user = new User();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        String url = API_BASE_URL + userID;
       // ArrayList<UserListItems> userList = restTemplate.getForObject(url, ArrayList.class);
        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, entity, User.class);
        user = response.getBody();


 //       ArrayList<> user = restTemplate.getForObject(url, ArrayList.class);
//        try {
//            CodewarsApiGetResponse response = restTemplate.getForObject(API_BASE_URL + userID, CodewarsApiGetResponse.class);
//            if (response != null && response.getData() != null) {
//                for (User user : response.getData().getUserInfoList()) {
//                    UserListItems items = new UserListItems();
//                    items.setUsersName(user.getUsername());
//                    items.setUsersClan(user.getClan());
//                    userList.add(items);
//                }
//            }
//        }catch(RestClientResponseException e){
//            System.out.println(e);
//        }catch(ResourceAccessException e){
//            System.out.println(e);
//        }
        return user;
    }

    public User[] getUserInfoList(String userID) {
        User[] user = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User[]> entity = new HttpEntity<>(user, headers);
        String url = API_BASE_URL + userID;

        ResponseEntity<User[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, User[].class);
        user = response.getBody();

        return user;
    }

}
