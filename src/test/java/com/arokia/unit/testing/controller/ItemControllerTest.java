package com.arokia.unit.testing.controller;

import com.arokia.unit.testing.model.Item;
import com.arokia.unit.testing.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public  void sampleItem_basic() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/sample-item").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")) //for json
                .andReturn();
    }

    //.json will call under the hood using mvn dependency <artifactId>jsonassert</artifactId> of spring-boot-starter-test
    // JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    @Test
    public  void itemFromBusinessService() throws Exception{

        //MockBean by default returns null, so if you run the code without below line it will throw unable to parse Json content.
        when(businessService.retreiveHardcodedItem()).thenReturn(new Item(2,"Item2",10,10));

        RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:Item2,price:10}")) //for json
                .andReturn();
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2,"Item2",10,10),
                        new Item(3,"Item3",20,20))
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:3,name:Item3,price:20}, {id:2,name:Item2,price:10}]"))
                .andReturn();
        //retrieveAllItems will return arrays back hence add []

    }
}