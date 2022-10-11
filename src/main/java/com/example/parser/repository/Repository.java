package com.example.parser.repository;

import com.example.parser.interfaces.IRepository;

import java.util.Map;
import java.util.Set;

public abstract class Repository<K, V> implements IRepository<K, V> {

    Map<K, V> keyToValue;

    @Override
    public V get(K key) {
        if (contains(key)) {
            return keyToValue.get(key);
        }
        return null;
    }

    @Override
    public boolean add(K key, V value) {
        if (keyToValue.containsKey(key)) {
            return false;
        }
        keyToValue.put(key, value);
        return true;
    }

    @Override
    public boolean contains(K key) {
        return !keyToValue.isEmpty() && keyToValue.containsKey(key);
    }

    @Override
    public boolean remove(K key) {
        if (keyToValue.containsKey(key)) {
            keyToValue.remove(key);
            return true;
        }
        return false;
    }

    public Set<K> getAllKeys() {
        return keyToValue.keySet();
    }

}
