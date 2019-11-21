package com.sc.demo.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
//为Ribbon客户端添加自定义配置
@RibbonClient(name = "sc-provider-user", configuration = ProjectConfig.class)
public class RibbonConfig {

}
