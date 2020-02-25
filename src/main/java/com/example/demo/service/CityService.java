package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.utils.RouteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private static List<City> cityList;
    @Autowired
    RouteUtils routeUtils;

    @PostConstruct
    private void setCityList() {
        cityList = routeUtils.getCityList();
    }

    public List<City> findByCity(String onboadringCity) {
        return cityList.stream().filter(city -> city.getCity1().equals(onboadringCity)).collect(Collectors.toList());
    }


}
