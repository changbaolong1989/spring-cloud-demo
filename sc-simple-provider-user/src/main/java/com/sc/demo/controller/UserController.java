package com.sc.demo.controller;

import com.sc.demo.entity.UserInfo;
import com.sc.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/users/{userId}")
    public UserInfo getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

}
