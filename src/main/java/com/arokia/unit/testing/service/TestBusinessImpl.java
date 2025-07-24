package com.arokia.unit.testing.service;

import com.arokia.unit.testing.data.TestDataService;

public class TestBusinessImpl {

    private TestDataService testDataService;

    public void setTestDataService(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        for(int value:data) {
            sum += value;
        }
        return sum;
        //Functional Style
        //return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }


    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = testDataService.retrieveAllData();
        for(int value:data) {
            sum += value;
        }
        /*
          Sometime instead of returning sum, it will store in DB like
          testDataService.storeSum(sum);
          Here in this case, we want to see whether above method is invoked like storeSum method is called
          and find out value of sum passed is the right value, which is achieved by verification.
         */
        return sum;
        //Functional Style
        //return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }
}
