package stuctures.collection.base;

public interface Collection {
    /**
     * Add element in collection
     *
     * @param element
     */
    void add(int element);

    /**
     * return count of elements, 0 - if is empty.
     */
    int size();

    /**
     * check is contain element in collection
     *
     * @param element - required element
     * @return - true, if element is contains
     */
    boolean contains(int element);

    /**
     * удаляет первое вхождение
     *
     * @param element - removed item
     */
    void removeFirst(int element);

    /**
     * удаляет последнее вхождение
     *
     * @param element - removed item
     */
    void removeLast(int element);

    /**
     * удаляет все встречающиеся
     *
     * @param element -  removed item
     */
    void removeAll(int element);

    /**
     * return object of iterator
     * @return
     */
    Iterator iterator();
}
