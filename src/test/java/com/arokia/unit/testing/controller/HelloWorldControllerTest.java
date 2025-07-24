package com.arokia.unit.testing.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorld_basic() throws Exception{ //MockMvc throws Exception
        //Call "/hello-world" GET application/json
        //In below we are sending get request to /hello-world and expect the data in Json format.
        RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
        //MvcResult result = mockMvc.perform(request).andReturn(); //To execute request
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                //.andExpect(content().json("Hello World")) //for json
                .andReturn();

        //verify "Hello World"
        //assertEquals("Hello World", result.getResponse().toString()); //will not convert response as expected String
        //assertEquals("Hello World", result.getResponse().getContentAsString());
        //as we use MockMvcResultMatchers, no need to use assertEquals. Use assertEquals for simple responses
    }
}