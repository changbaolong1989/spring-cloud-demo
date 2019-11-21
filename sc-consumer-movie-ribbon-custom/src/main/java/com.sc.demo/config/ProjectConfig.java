package com.sc.demo.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProjectConfig {

    @Bean
    @LoadBalanced
    //LoadBalanced注解自动启动配置负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 自定义Ribbon负载均衡规则
     */
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
