package com.fmi.dsa.hashmap;

/**
 *
 * @author Dimitar
 * @param <V>
 */
class MapEntry<V> {

    private final String key;
    private V value;
    private MapEntry next;

    public MapEntry(String key, V value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MapEntry getNext() {
        return next;
    }

    public void setNext(MapEntry next) {
        this.next = next;
    }

}
