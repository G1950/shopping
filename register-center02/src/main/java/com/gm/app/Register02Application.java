package com.gm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName RegisterApplication
 * @Description Eureka注册中心
 * @Author Gm
 * @Date 2020/7/6/006 15:58
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class Register02Application {
    public static void main(String[] args) {
        SpringApplication.run(Register02Application.class, args);
    }
}
