package com.tcjbeckett.CodewarsProject.controller;

import com.tcjbeckett.CodewarsProject.model.User;
import com.tcjbeckett.CodewarsProject.model.UserListItems;
import com.tcjbeckett.CodewarsProject.services.CodeWarsApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;

@RestController
@RequestMapping("")
public class CodewarsController {

    private CodeWarsApiService service;

    public CodewarsController(CodeWarsApiService codeWarsApiService){
        this.service = codeWarsApiService;
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public User getUserInfo(){
        return service.getUser("tcjbeckett");
    }

//    @RequestMapping
//    public String hi(){
//        return "Hi";
//    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public User getOneUser(){
        return service.getOneUser("tcjbeckett");
    }

//    @RequestMapping(path = "", method = RequestMethod.GET)
//    public User[] getUserInfoList(String userID){
//        return service.getUserInfoList("tcjbeckett");
//    }

//    @RequestMapping(path = "", method = RequestMethod.GET)
//    public ArrayList<UserListItems> getUserInfomation(){
//        return service.getUserInfoList("tcjbeckett");
//    }

}
