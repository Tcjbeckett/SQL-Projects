package com.tcjbeckett.CodewarsProject.services;

import com.tcjbeckett.CodewarsProject.model.CodewarsApiGetResponse;
import com.tcjbeckett.CodewarsProject.model.User;
import com.tcjbeckett.CodewarsProject.model.UserListItems;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

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

    public ArrayList<UserListItems> getUserInfoList(String userID){
        ArrayList<UserListItems> userList = new ArrayList<>();

        try {
            CodewarsApiGetResponse response = restTemplate.getForObject(API_BASE_URL + userID, CodewarsApiGetResponse.class);
            if (response != null && response.getData() != null) {
                for (User user : response.getData().getUserInfoList()) {
                    UserListItems items = new UserListItems();
                    items.setUsersName(user.getUsername());
                    items.setUsersClan(user.getClan());
                    userList.add(items);
                }
            }
        }catch(RestClientResponseException e){
            System.out.println(e);
        }catch(ResourceAccessException e){
            System.out.println(e);
        }
        return userList;
    }
}
