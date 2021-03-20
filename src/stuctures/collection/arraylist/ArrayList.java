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
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
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
        int lastPosition = lastIndexOf(element);
        removeAt(lastPosition);
    }

    @Override
    public void removeAll(int element) {
        int step = -1;
        while (step < count) {
            if (elements[++step] == element) {
                removeAt(step);
            }
        }
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
        for (int i = index; i < count; i++) {
            elements[i] = elements[i + 1];
        }
        count--;
    }

    @Override
    public int indexOf(int element) {
        int step = 0;
        while (elements[step] != element && step < elements.length) {
            step++;
        }
        if (step != elements.length) {
            return ++step;
        }
        return -1;

    }

    @Override
    public int lastIndexOf(int element) {
        int lastIndex = -1;
        int step = -1;
        while (step < elements.length - 1) {
            if (elements[++step] == element) {
                lastIndex = step;
            }
        }

        return lastIndex;
    }
}
