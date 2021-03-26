package generics.itis.part1.collections;

public interface Collection<E> {
    /**
     * Add element in collection
     *
     * @param element
     */
    void add(E element);

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
    boolean contains(E element);

    /**
     * удаляет первое вхождение
     *
     * @param element - removed item
     */
    void removeFirst(E element);

    /**
     * удаляет последнее вхождение
     *
     * @param element - removed item
     */
    void removeLast(E element);

    /**
     * удаляет все встречающиеся
     *
     * @param element -  removed item
     */
    void removeAll(E element);

    /**
     * return object of iterator
     * @return
     */
}
