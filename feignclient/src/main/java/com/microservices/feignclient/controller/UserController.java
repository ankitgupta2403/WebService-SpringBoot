package com.microservices.feignclient.controller;

import com.microservices.feignclient.client.UserClient;
import com.microservices.feignclient.models.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserClient client;

    @GetMapping("/findAllUsers")
    public List<ServiceResponse> getUsers()
    {
        return client.getUsers();
    }

}
