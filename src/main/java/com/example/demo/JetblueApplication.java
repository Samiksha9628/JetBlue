package com.example.demo;

import com.example.demo.utils.RouteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JetblueApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetblueApplication.class, args);
    }


}
