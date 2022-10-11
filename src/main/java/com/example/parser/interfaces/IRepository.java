package com.example.parser.interfaces;

public interface IRepository<K, V> {
    V get(K key);
    boolean add(K key, V value);
    boolean contains(K key);
    boolean remove(K key);
}
