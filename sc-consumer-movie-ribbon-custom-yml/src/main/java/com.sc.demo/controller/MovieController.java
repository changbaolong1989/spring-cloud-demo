package com.sc.demo.controller;

import com.sc.demo.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Resource
    //Rest模板
    private RestTemplate restTemplate;

    @Resource
    //负载均衡客户端
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/users/{userId}")
    public UserInfo findUserById(@PathVariable String userId) {
        //当Ribbon和Eureka配合使用时，会自动将微服务主机名映射成微服务网络地址   虚拟主机名不能包含"_"
        return restTemplate.getForObject("http://sc-provider-user/" + "users/" + userId, UserInfo.class);
    }

    /**
     * 用户微服务的Log
     * 输出选择实例信息，实现负载均衡
     */
    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("sc-provider-user");
        //打印当前选择了哪个节点
        logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

}
