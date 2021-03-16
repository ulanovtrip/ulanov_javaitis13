package stuctures.collection.base;

public interface List extends Collection {

    /**
     * Get element from collection by index
     * @param index - index of element
     * @return - element from index, if not found - return -1
     */
    int get(int index);

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
    int indexOf(int element);

    /**
     * return index of elemet, last occurrence
     * @param element
     * @return
     */
    int lastIndexOf(int element);
}
