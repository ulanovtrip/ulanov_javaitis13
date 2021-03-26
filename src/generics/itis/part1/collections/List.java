package generics.itis.part1.collections;

public interface List<V> extends Collection<V> {

    /**
     * Get element from collection by index
     * @param index - index of element
     * @return - element from index, if not found - return -1
     */
    V get(int index);

    /**
     * delete elem by index
     * @param index - index of element
     */
    void removeAt(int index);

    /**
     * return index of element, first occurrence
     * @param element - value of element
     * @return - value of index, else -1
     */
    int indexOf(V element);

    /**
     * return index of elemet, last occurrence
     * @param element
     * @return
     */
    int lastIndexOf(V element);
}
