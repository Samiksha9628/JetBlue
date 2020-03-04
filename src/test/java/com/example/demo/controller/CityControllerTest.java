package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.CityService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
public class CityControllerTest {
    private MockMvc mvc;

    @InjectMocks
    private CityController cityController;
    @Mock
    private CityService cityService;

    @Before
    public void setUp() {
        initMocks(this);
        mvc = standaloneSetup(cityController).build();
    }

    @Test
    public void testFindCity() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        when(cityService.findByCity(any())).thenReturn(initList());
        MvcResult mvcResult = mvc.perform(get("/api/search/ABC").accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
        List<City> result = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<City>>() {
        });
        assertThat(result.size()).isEqualTo(2);


    }

    private List<City> initList() {
        City objcity1 = new City();
        objcity1.setCity1("ABC");
        objcity1.setCity2("PQR");
        objcity1.setCity3("LMN");
        objcity1.setMint("XYZ");
        objcity1.setSeasonal("UDR");
        City objcity2 = new City();
        objcity1.setCity1("ABC");
        objcity1.setCity2("PQR");
        objcity1.setCity3("LMN");
        objcity1.setMint("XYZ");
        objcity1.setSeasonal("UDR");
        List<City> objcity = new ArrayList<>();
        objcity.add(objcity1);
        objcity.add(objcity2);

        return objcity;

    }
}
