package com.arokia.unit.testing.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List mock = mock(List.class);
    @Captor
    ArgumentCaptor<String> captor;


    @Test
    public void size_basic() {
        //List mock = mock(List.class);
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnMultipleValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }


    @Test
    public void returnWithParameter() {
        when(mock.get(0)).thenReturn("Arokiasamy");
        assertEquals("Arokiasamy",mock.get(0));
        assertEquals(null,mock.get(1));
    }

    @Test
    public void returnWithGenericParameter() {
        when(mock.get(anyInt())).thenReturn("Arokiasamy");
        assertEquals("Arokiasamy",mock.get(0));
        assertEquals("Arokiasamy",mock.get(1));
    }

    @Test
    public void verificationBasics(){
        //System Under test
        String value = (String) mock.get(0);

        //Verify
        verify(mock).get(0);
        String value2 = (String) mock.get(1);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing(){
        //System Under Test
        mock.add("engineeringLead");

        //Verification
        /* ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
            Instead of above can use below
            @Captor
            ArgumentCaptor<String> stringArgumentCaptor;
        */
        verify(mock).add(captor.capture());
        assertEquals("engineeringLead", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {

        //SUT
        mock.add("engineeringLead");
        mock.add("internetBanking");

        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("engineeringLead", allValues.get(0));
        assertEquals("internetBanking", allValues.get(1));

    }

    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));//null
        System.out.println(arrayListMock.size());//0
        arrayListMock.add("Test");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());//0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());//5
    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));//Test0
        System.out.println(arrayListSpy.size());//1
        arrayListSpy.add("Test");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());//3

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());//5

        arrayListSpy.add("Test4");
        System.out.println(arrayListSpy.size());//5

        verify(arrayListSpy).add("Test4");
    }
}
