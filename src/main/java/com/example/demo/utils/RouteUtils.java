package com.example.demo.utils;

import com.example.demo.model.City;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RouteUtils {
    private List<City> cityList = new ArrayList<>();

    public List getCityList() {
        if (cityList.isEmpty())
            loadCityRoutes();
        return cityList;
    }

    public List loadCityRoutes() {
        try {
            File file = ResourceUtils.getFile("classpath:Routes.csv");
            InputStream inputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            cityList = br.lines().skip(1).map(csvCityObj).collect(Collectors.toList());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cityList;

    }

    public static Function<String, City> csvCityObj = (line) -> {

        String[] record = line.split(",");

        City city = new City();
        city.setCity1(record[0].trim());
        city.setCity2(record[1].trim());
        city.setCity3(record[2].trim());
        city.setMint(record[3].trim());
        city.setSeasonal(record[4].trim());
        return city;
    };

}
