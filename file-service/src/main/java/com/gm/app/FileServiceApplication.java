package com.gm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName FileServiceApplication
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/15/015 17:34
 * @Version 1.0
 **/
@SpringBootApplication(scanBasePackages = {"com.gm"})
@EnableEurekaClient
public class FileServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileServiceApplication.class, args);
    }
}
