package com.example.parser.repository;

import com.example.parser.model.OrderData;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class OrderDataRepository extends Repository<Integer, OrderData> {

    private static int id = 1;

    public OrderDataRepository() {
        keyToValue = new HashMap<>();
    }

    public boolean add(OrderData value) {
        return add(id++, value);
    }

    public Set<Integer> getAllIds() {
        return getAllKeys();
    }
}
