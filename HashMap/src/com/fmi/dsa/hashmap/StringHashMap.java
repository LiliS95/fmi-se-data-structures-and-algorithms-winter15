package com.fmi.dsa.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Dimitar
 * @param <V>
 */
public class StringHashMap<V> implements MyMap<V> {

    private final double LOAD_FACTOR = 0.75;
    private final int DEFAULT_BINARY_POWER = 2;

    private int size;
    private int capacity;
    private List<MapEntry> table;

    private int binaryPower = 2;

    public StringHashMap() {
        init(1 << DEFAULT_BINARY_POWER);
    }

    private void init(int power) {
        this.capacity = power;
        this.table = new ArrayList<>(Collections.nCopies(capacity, null));
        this.size = 0;
    }

    @Override
    public void insert(String key, V value) {
        int hash = generateHash(key);

        if (table.get(hash) == null) {
            table.set(hash, new MapEntry(key, value));
            size++;
        } else {
            MapEntry entry = getTableEntry(table.get(hash), key);
            if (entry != null) {
                entry.setValue(value);
            } else {
                MapEntry newEntry = new MapEntry(key, value);
                newEntry.setNext(table.get(hash));
                table.set(hash, newEntry);
                size++;
            }
        }

        if ((double) size / (double) capacity >= LOAD_FACTOR) {
            resize(1 << ++binaryPower);
        }
    }

    @Override
    public void delete(String key) {
        int hash = generateHash(key);

        if (table.get(hash) == null) {
            return;
        }

        MapEntry currentEntry = table.get(hash);
        MapEntry previousEntry = null;

        while (currentEntry != null) {
            if (currentEntry.getKey().equals(key)) {
                if (previousEntry != null) {
                    previousEntry.setNext(currentEntry.getNext());
                } else {
                    table.set(hash, currentEntry.getNext());
                }
                size--;
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.getNext();
        }

        if ((double) size / (double) capacity <= 1 - LOAD_FACTOR) {
            resize(1 << --binaryPower);
        }
    }

    @Override
    public void clear() {
        table.clear();
        init(1 << DEFAULT_BINARY_POWER);
    }

    @Override
    public V get(String key) {
        int hash = generateHash(key);
        MapEntry<V> entry;
        if (table.get(hash) != null) {
            if ((entry = getTableEntry(table.get(hash), key)) != null) {
                return entry.getValue();
            }
        }
        throw new NoSuchElementException("The key '" + key + "' is not present the hashmap");
    }

    @Override
    public boolean contains(String key) {
        int hash = generateHash(key);
        if (table.get(hash) == null) {
            return false;
        } else {
            MapEntry bucket = getTableEntry(table.get(hash), key);
            return bucket != null;
        }
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int generateHash(String str) {
        int h = str.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        h = h ^ (h >>> 7) ^ (h >>> 4);
        return Math.abs(h) % this.capacity;
    }

    private MapEntry getTableEntry(MapEntry entry, String key) {
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
            entry = entry.getNext();
        }
        return null;
    }

    private void resize(int newCapacity) {
        List<MapEntry> oldTable = table;

        init(newCapacity);

        for (MapEntry<V> oldEntry : oldTable) {
            while (oldEntry != null) {
                this.insert(oldEntry.getKey(), oldEntry.getValue());
                oldEntry = oldEntry.getNext();
            }
        }
    }
}
