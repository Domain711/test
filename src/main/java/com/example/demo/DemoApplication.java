package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 配置扫描路径
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.controller"})
@ComponentScan(basePackages = {"com.example.demo.service"})
@MapperScan(basePackages = {"com.example.demo.dao"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

