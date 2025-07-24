package com.arokia.unit.testing.controller;

import com.arokia.unit.testing.repo.ItemRepository;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
/*@SpringBootTest - This will launches an entire Spring Boot Application as like UnitTestingApplication.java
SpringBootTest.WebEnvironment.RANDOM_PORT - We want to launch a web application to perform
integration testing with controller.
 */
public class ItemControllerIntegTest {

    //To call a service, use TestRestTemplate and it is already aware of which random port is assigned.
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        //provide the URL
        String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003},{id:10004}]",
                response, false);
    }

}