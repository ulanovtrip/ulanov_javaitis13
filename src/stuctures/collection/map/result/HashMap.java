package stuctures.collection.map.result;

import stuctures.collection.map.primitive.Map;

public class HashMap<K, V> implements Map<K, V> {

    private final static int DEFAULT_SIZE = 10;
    private V[] values;

    HashMap() {
        values = (V[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = Math.abs(key.hashCode() % DEFAULT_SIZE);
        values[index] = value;
    }

    @Override
    public V get(K key) {
        int index = Math.abs(key.hashCode() % DEFAULT_SIZE);
        return values[index];
    }
}
