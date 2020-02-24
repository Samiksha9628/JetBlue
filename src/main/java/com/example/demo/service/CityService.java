package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.utils.RouteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    RouteUtils routeUtils;

    public List<City> findByCity(String onboadringCity) {
        List<City> cityList = routeUtils.getCityList();
        return cityList.stream().filter(city -> city.getCity1().equals(onboadringCity)).collect(Collectors.toList());
    }


}
