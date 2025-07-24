package com.arokia.unit.testing.repo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import com.arokia.unit.testing.model.Item;

import java.util.List;

@DataJpaTest//Will launch a in-memory database, it will populate all the data present in data.sql
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(4,items.size());
    }

    @Test
    public void testFindOne() {
        Item item = repository.findById(10001).get();
        assertEquals("Chocolates",item.getName());
    }

}