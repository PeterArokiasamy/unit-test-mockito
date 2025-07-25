package com.arokia.unit.testing.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
    @Test
    public void learning() {
        String responseFromService = "[" +
                "{\"id\":10000, \"name\":\"Pencil\", \"quantity\":5}," +
                "{\"id\":10001, \"name\":\"Pen\", \"quantity\":15}," +
                "{\"id\":10002, \"name\":\"Eraser\", \"quantity\":10}" +
                "]";

        DocumentContext context = JsonPath.parse(responseFromService);
        System.out.println("Value of context :: "+context.toString());

        int length = context.read("$.length()"); //$ = root
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id"); //"Find .id under the root ."

        assertThat(ids).containsExactly(10000,10001,10002);

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString()); //From 0 to 0,1 = 2
        System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
        System.out.println(context.read("$.[?(@.quantity==5)]").toString());

    }
}
