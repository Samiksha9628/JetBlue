package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.service.CityService;

@RestController
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping(value = "/search/{onboardingCity}")
    public List<City> findCity(@PathVariable String onboardingCity, HttpServletResponse response) {
        final List<City> byCity = cityService.findByCity(onboardingCity);
        return byCity;
    }

}
