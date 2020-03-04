package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.utils.RouteUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CityServiceTest {
    @InjectMocks
    CityService cityService;
    @Mock
    RouteUtils routeUtils;

    @Test
    public void testFindByCity() {

        when(routeUtils.getCityMap()).thenReturn(intiMap());
        List<City> result = cityService.findByCity("ABC");
        assertThat(result.size()).isEqualTo(1);

    }

    private Map<String, List<City>> intiMap() {
        Map cityMap = new HashMap();
        City objcity1 = new City();
        objcity1.setCity1("ABC");
        objcity1.setCity2("PQR");
        objcity1.setCity3("LMN");
        objcity1.setMint("XYZ");
        objcity1.setSeasonal("UDR");

        City objcity2 = new City();
        objcity1.setCity1("LMN");
        objcity1.setCity2("PQR");
        objcity1.setCity3("LMN");
        objcity1.setMint("XYZ");
        objcity1.setSeasonal("UDR");

        List<City> objList1 = new ArrayList<>();
        objList1.add(objcity1);

        List<City> objList2 = new ArrayList<>();
        objList2.add(objcity2);

        cityMap.put("ABC", objList1);
        cityMap.put("LMN", objList2);

        return cityMap;

    }
}
