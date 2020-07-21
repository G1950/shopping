package com.gm.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName Application
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 16:15
 * @Version 1.0
 **/
@SpringBootApplication(scanBasePackages = {"com.gm"})
@MapperScan(basePackages = {"com.gm.mapper"})
@EnableEurekaClient
public class ContentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentApplication.class, args);
    }
}
