package com.fmi.dsa.hashmap;

/**
 *
 * @author Dimitar
 */
public interface MyMap<V> {

    void insert(String key, V value);

    void delete(String key);

    void clear();

    V get(String key);

    boolean contains(String key);

    int capacity();

    int size();

}
