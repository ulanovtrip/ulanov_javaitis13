package stuctures.collection.map.simple;

public class ArrayIntegerKeyMapImpl<V> implements IntegerKeyMap<V> {

    private V[] array = (V[]) new Object[10];

    @Override
    public void put(int key, V value) {
        array[key] = value;
    }

    @Override
    public V get(int key) {
        return array[key];
    }
}
