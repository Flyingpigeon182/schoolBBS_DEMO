package com.example.news_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("generator.mapper")
@ComponentScan("Controller")
@ComponentScan("generator.service")
@SpringBootApplication
public class NewsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsDemoApplication.class, args);

    }

}
