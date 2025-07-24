package com.arokia.unit.testing.service;

import com.arokia.unit.testing.data.TestDataService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDataServiceStub implements TestDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

class TestDataServiceEmptyStub implements TestDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class TestDataServiceOneElementStub implements TestDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }
}

public class TestBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        TestBusinessImpl business = new TestBusinessImpl();
        // business.setTestDataService(testDataService);
        // But above code will update into actual database hence create a stub implementation inside this class
        business.setTestDataService(new TestDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        TestBusinessImpl business = new TestBusinessImpl();
        business.setTestDataService(new TestDataServiceEmptyStub());
        int actualResult = business.calculateSumUsingDataService();//new int[] {}
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        TestBusinessImpl business = new TestBusinessImpl();
        business.setTestDataService(new TestDataServiceOneElementStub());
        int actualResult = business.calculateSumUsingDataService();//new int[] { 5 }
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

}