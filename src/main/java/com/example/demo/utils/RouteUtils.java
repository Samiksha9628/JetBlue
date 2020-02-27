package com.example.demo.utils;

import com.example.demo.model.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.*;
import java.util.function.Function;


@Component
public class RouteUtils {
    private Map<String, List<City>> cityMap = new HashMap<>();

    @Value("${file.location:test}")
    private String filename;

    @PostConstruct
    public void intit() {
        loadCityRoutes(filename);
    }

    public Map<String, List<City>> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<String, List<City>> cityMap) {
        this.cityMap = cityMap;
    }

    public void loadCityRoutes(String filename) {
        try {  //try with resources
            File file = ResourceUtils.getFile("classpath:" + filename);
            InputStream inputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            br.lines().skip(1).map(csvCityObj).forEach(c -> {
                if (cityMap.containsKey(c.getCity1())) {
                    cityMap.get(c.getCity1()).add(c);
                } else {
                    List<City> cityinput = new ArrayList<>();
                    cityinput.add(c);
                    cityMap.put(c.getCity1(), cityinput);
                }
            });
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
