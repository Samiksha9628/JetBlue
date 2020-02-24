package com.example.demo.service;

import com.example.demo.utils.RouteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CityCommandLineRunner implements CommandLineRunner {
    @Autowired
    private RouteUtils routeUtils;

    @Override
    public void run(String... args) throws Exception {
        routeUtils.loadCityRoutes();
    }
}

