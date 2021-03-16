package stuctures.collection.arraylist;

import stuctures.collection.base.Iterator;
import stuctures.collection.base.List;

public class ArrayList implements List {

    private static final int DEFAULT_SIZE = 10;
    private int[] elements;
    private int count;

    public ArrayList() {
        this.elements = new int[DEFAULT_SIZE];
        this.count = 0;
    }

    private class ArrayListIterator implements Iterator {

        private int countPosition = 0;

        @Override
        public int next() {
            int nextValue = elements[countPosition];
            countPosition++;
            return nextValue;
        }

        @Override
        public boolean hasNext() {
            return countPosition < count;
        }
    }

    @Override
    public void add(int element) {
        // if array is full
        if (count == elements.length) {
            int[] tmpArray = new int[elements.length + elements.length / 2];
            for (int i = 0; i < elements.length; i++) {
                tmpArray[i] = elements[i];

            }
            elements = tmpArray;
        }
        elements[count] = element;
        count++;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(int element) {
        // TODO
        return false;
    }

    @Override
    public void removeFirst(int element) {
        int positionOfRemovingElem = -1;

        for (int i = 0; i < count; i++) {
            if (elements[i] == element) {
                positionOfRemovingElem = i;
                break;
            }
        }
        // теперь на место этого элемента двигается весь массив после него
        for (int i = positionOfRemovingElem; i < count; i++) {
            elements[i] = elements[i + 1];
        }
        // уменьшить число эелементов
        count--;
    }

    @Override
    public void removeLast(int element) {
        // TODO
    }

    @Override
    public void removeAll(int element) {
        // TODO
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    @Override
    public int get(int index) {
        if (index >= 0 && index < count) {
            return elements[index];
        }
        return -1;
    }

    @Override
    public void removeAt(int index) {
        // TODO
    }

    @Override
    public int indexOf(int element) {
        // TODO
        return 0;
    }

    @Override
    public int lastIndexOf(int element) {
        // TODO
        return 0;
    }
}
