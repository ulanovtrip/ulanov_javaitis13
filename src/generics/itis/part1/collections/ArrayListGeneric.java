package generics.itis.part1.collections;

public class ArrayListGeneric<T> implements List<T>{

    private static final int DEFAULT_SIZE = 10;
    private T[] elements;
    private int count;

    public ArrayListGeneric() {
        this.elements = (T[]) new Object[DEFAULT_SIZE];
        this.count = 0;
    }

    public void add(T element) {
        // if array is full
        if (count == elements.length) {
            T[] tmpArray = (T[]) new Object[elements.length + elements.length / 2];
            for (int i = 0; i < elements.length; i++) {
                tmpArray[i] = elements[i];
            }
            elements = tmpArray;
        }
        elements[count] = element;
        count++;
    }

    public int size() {
        return count;
    }

    public boolean contains(T element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void removeFirst(T element) {
        int positionOfRemovingElem = -1;

        for (int i = 0; i < count; i++) {
            if (elements[i].equals(element)) {
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

    public void removeLast(T element) {
        int lastPosition = lastIndexOf(element);
        removeAt(lastPosition);
    }

    public void removeAll(T element) {
        int step = -1;
        while (step < count) {
            if (elements[++step].equals(element)) {
                removeAt(step);
            }
        }
    }

    public T get(int index) {
        if (index >= 0 && index < count) {
            return elements[index];
        }
        return null;
    }

    public void removeAt(int index) {
        for (int i = index; i < count; i++) {
            elements[i] = elements[i + 1];
        }
        count--;
    }

    public int indexOf(T element) {
        int step = 0;
        while (!(elements[step].equals(element)) && step < elements.length) {
            step++;
        }
        if (step != elements.length) {
            return ++step;
        }
        return -1;
    }

    public int lastIndexOf(T element) {
        int lastIndex = -1;
        int step = -1;
        while (step < elements.length - 1) {
            if (elements[++step].equals(element)) {
                lastIndex = step;
            }
        }

        return lastIndex;
    }
}
