package com.sc.demo.controller;

import com.sc.demo.entity.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/users/{userId}")
    public UserInfo findUserById(@PathVariable String userId) {
        return restTemplate.getForObject("http://localhost:8060/users/" + userId, UserInfo.class);
    }

}
