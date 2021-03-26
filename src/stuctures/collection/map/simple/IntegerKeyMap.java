package stuctures.collection.map.simple;

// Map - это концепция, т.е. словарь, он же ассоциативный массив.
public interface IntegerKeyMap<T> {
    void put(int key, T value);

    T get(int key);
}
