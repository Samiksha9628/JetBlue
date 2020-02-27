package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@Configuration
@ComponentScan
@PropertySource(value = "classpath:application.properties")
public class JetblueApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetblueApplication.class, args);
    }


}
