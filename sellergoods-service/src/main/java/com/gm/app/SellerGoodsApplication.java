package com.gm.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName SellerGoodsApplication
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/10/010 19:26
 * @Version 1.0
 **/
@SpringBootApplication(scanBasePackages = {"com.gm"})
@MapperScan(basePackages = {"com.gm.mapper"})
@EnableEurekaClient
public class SellerGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellerGoodsApplication.class, args);
    }
}
