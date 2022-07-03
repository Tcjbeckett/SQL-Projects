package com.tcjbeckett.CodewarsProject.controller;

import com.tcjbeckett.CodewarsProject.model.User;
import com.tcjbeckett.CodewarsProject.services.CodeWarsApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("")
public class CodewarsController {

    private CodeWarsApiService service;

    public CodewarsController(CodeWarsApiService codeWarsApiService){
        this.service = codeWarsApiService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public User getUserInfo(){
        return service.getUser("tcjbeckett");
    }

}
