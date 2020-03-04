package com.example.demo.utils;


import com.example.demo.model.City;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class RouteUtilsTest {
    @InjectMocks
    private RouteUtils routeUtils;

    String fileName = "Routes.csv";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(routeUtils, "filename", fileName);
        routeUtils.init();
    }

    @Test
    public void testGetCityMapWithoutNull() {

        Map<String, List<City>> result = routeUtils.getCityMap();
        assertNotNull(result);

    }


}
