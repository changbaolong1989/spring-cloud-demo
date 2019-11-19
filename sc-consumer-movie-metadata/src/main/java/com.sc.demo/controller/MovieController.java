package com.sc.demo.controller;

import com.sc.demo.entity.UserInfo;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/users/{userId}")
    public UserInfo findUserById(@PathVariable String userId) {
        return restTemplate.getForObject("http://localhost:8060/users/" + userId, UserInfo.class);
    }

    /**
     * 通过applicationName查询指定微服务在Eureka上的实例列表
     */
    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances("sc-provider-user");
    }

}
