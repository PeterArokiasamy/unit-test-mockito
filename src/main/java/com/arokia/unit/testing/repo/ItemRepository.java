package com.arokia.unit.testing.repo;

import com.arokia.unit.testing.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
