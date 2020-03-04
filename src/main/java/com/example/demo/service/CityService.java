package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.utils.RouteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityService {

    @Autowired
    RouteUtils routeUtils;

    public List<City> findByCity(String onboadringCity) {
        return routeUtils.getCityMap().get(onboadringCity);
    }


}
