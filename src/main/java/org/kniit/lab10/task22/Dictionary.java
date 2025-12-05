package org.kniit.lab10.task22;

import java.util.*;

public class Dictionary<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    public void put(K key, V value) {
        int i = keys.indexOf(key);
        if (i == -1) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(i, value);
        }
    }
    public V get(K key) {
        int i = keys.indexOf(key);
        if (i != -1) {
            return values.get(i);
        }
        return null;
    }
    public void remove(K key) {
        int i = keys.indexOf(key);
        if (i != -1) {
            keys.remove(i);
            values.remove(i);
        }
    }
}
