package com.arokia.unit.testing.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBusinessImplTest {

    @Test
    void calculateSum() {
        TestBusinessImpl business = new TestBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_empty() {
        TestBusinessImpl business = new TestBusinessImpl();
        int actualResult = business.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
}