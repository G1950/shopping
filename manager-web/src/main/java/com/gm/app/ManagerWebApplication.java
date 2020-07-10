package com.gm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName ManagerWebApplication
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 20:54
 * @Version 1.0
 **/
@SpringBootApplication(scanBasePackages = {"com.gm"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.gm.feign"})
public class ManagerWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerWebApplication.class, args);
    }
}
