package stuctures.collection.map.result;

import stuctures.collection.map.primitive.Map;

public class HashMap<K, V> implements Map<K, V> {

    private final static int DEFAULT_SIZE = 10;

    // вложенный класс для списка в bucket
    private static class EntryNode<K, V> {
        private K key;
        private V value;
        private EntryNode<K, V> next;

        EntryNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // массив узлов для хранения
    private EntryNode<K, V>[] table;

    HashMap() {
        // при создании объекта мапы размер будет 10
        table = new EntryNode[DEFAULT_SIZE];
    }

    @Override
    public void put(K key, V value) {
        // получаем hash-code ключа, обрезаем его до размеров массива, получаем индекс
        int index = Math.abs(key.hashCode() % DEFAULT_SIZE);
        // под этим индексом кладем его в массив
        // если в данном bucket-e ничего нет
        if (table[index] == null) {
            // создадим новый объект узла с текущими данными
            EntryNode<K, V> newNode = new EntryNode<>(key, value);
            // и положим узел в массив table, он будет первым
            table[index] = newNode;
        } else {
            // если не пустой, то нужно пройтись по всему bucket-у и найти ключ
            // для начала запоминаем первый элемент bucket-a
            EntryNode<K, V> current = table[index];
            // потом идём по всему текущему списку
            while (current != null) {
                // чтобы не тратить на сравнение по equals, проверим hash-code, он быстрее
                // ситуация - если hash-cod-ы равны, не файкт, что там один и тот же ключ
                // но если hash-cod-ы разные, то объекты точно разные
                if (current.key.hashCode() != key.hashCode()) {
                    // переходим сразу к след. узлу
                    current = current.next;
                } else {
                    // если совпали по hash-code, нужно проверить, не тот ли ключ который нам нужен?
                    // для этого нужно проверить по equals
                    if (current.key.equals(key)) {
                        // если этот тот же самый ключ, то делаем замену
                        current.value = value;
                        // после замены нужно выйти из цикла
                        return;
                    } else {
                        // если ключ не совпал, то идём дальше
                        current = current.next;
                    }
                }
            }
            // если оказались здесь, значит в списке не нашли ключ
            // значит нужно добавить его в bucket
            EntryNode<K, V> newNode = new EntryNode<>(key, value); // создаём новый узел
            // у нового узла, след. узел становится первый узел в bucket
            newNode.next = table[index];
            // делаем новый узел первым в bucket
            table[index] = newNode;
        }
    }

    @Override
    public V get(K key) {

        int index = Math.abs(key.hashCode() % DEFAULT_SIZE);
        EntryNode<K, V> current = table[index];
        V value = null;

        while (current != null) {

            if (current.key.hashCode() != key.hashCode()) {
                current = current.next;
            } else {
                if (current.key.equals(key)) {
                    value = current.value;
                    break;
                } else {
                    current = current.next;
                }
            }
        }
        return value;
    }
}
