package com.arokia.unit.testing.service;

import com.arokia.unit.testing.data.TestDataService;
import com.arokia.unit.testing.model.Item;
import com.arokia.unit.testing.repo.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    ItemBusinessService business;

    @Mock
    ItemRepository repository;

    @Test
    public void retrieveAllItems_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item
                        (2,"Item2",10,10),
                new Item(3,"Item3",20,20)
                ));

        List<Item> items = business.retrieveAllItems();
        assertEquals(100,items.get(0).getValue()); //10 * 10 = 100 will be value
        assertEquals(400,items.get(1).getValue()); //20 * 20 = 400 will be value

    }

}