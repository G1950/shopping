package com.gm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName ShopWebApplication
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/14/014 10:05
 * @Version 1.0
 **/
@SpringBootApplication(scanBasePackages = {"com.gm"})
@EnableFeignClients(basePackages = {"com.gm.feign"})
@EnableEurekaClient
public class ShopWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopWebApplication.class, args);
    }
}
