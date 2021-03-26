package stuctures.collection.map.primitive;

public class PrimitiveMapImpl<K, V> implements Map<K, V> {

    private static final int MAX_SIZE = 10;

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // массив для хранения
    private Entry<K, V> entries[];

    private int count;

    public PrimitiveMapImpl() {
        this.entries = new Entry[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (entries[i].key.equals(key)) {
                entries[i].value = value;
                return;
            }
        }
        this.entries[count] = new Entry<>(key, value);
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (entries[i].key.equals(key)) {
                return entries[i].value;
            }
        }
        return null;
    }
}
