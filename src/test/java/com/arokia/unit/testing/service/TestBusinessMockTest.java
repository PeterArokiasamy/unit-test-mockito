package com.arokia.unit.testing.service;

import com.arokia.unit.testing.data.TestDataService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestBusinessMockTest {

    //TestBusinessImpl business = new TestBusinessImpl();
    @InjectMocks
    TestBusinessImpl business;

    /*TestDataService dataServiceMock = mock(TestDataService.class);
    @BeforeEach
    public void before(){
        business.setTestDataService(dataServiceMock);
    }
    By using @Mock, setter invocation will be done internally by using @ExtendWith(MockitoExtension.class)
    */
    @Mock
    TestDataService dataServiceMock;


    @Test
    public void calculateSumUsingDataService_basic() {
        /*TestBusinessImpl business = new TestBusinessImpl();
        TestDataService dataServiceMock = mock(TestDataService.class);*/
        //dataServiceMock retrieveAllData new int[] {1,2,3} -- to achieve
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        //When () is called, then return 1,2,3
        //business.setTestDataService(new TestDataServiceStub());
        //business.setTestDataService(dataServiceMock); -- moved to BeforeEach
        /*int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);*/
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        /*TestBusinessImpl business = new TestBusinessImpl();
        TestDataService dataServiceMock = mock(TestDataService.class);*/
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        //business.setTestDataService(new TestDataServiceEmptyStub());
        //business.setTestDataService(dataServiceMock); -- moved to BeforeEach
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        /*TestBusinessImpl business = new TestBusinessImpl();
        TestDataService dataServiceMock = mock(TestDataService.class);*/
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
        //business.setTestDataService(new TestDataServiceOneElementStub());
        //business.setTestDataService(dataServiceMock); -- moved to BeforeEach
        assertEquals(5, business.calculateSumUsingDataService());
    }
}
