package stuctures.collection.linkedlist;

import stuctures.collection.base.Iterator;
import stuctures.collection.base.List;

public class LinkedList implements List {

    // вложенный класс, чтобы инкапсулировать
    private static class Node {
        // модификаторы не нужны, т.к. в одной области находятся
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public class LinkedListIterator implements Iterator {
        private Node current;

        public LinkedListIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public int next() {
            // запомнили текущее значение
            int value = current.value;
            // перешли к следующему
            current = current.next;
            // вернули значение
            return value;
        }
    }

    /*
    Чтобы иметь информация о всём связном списке нам нужно хранить ссылку только на первый элемент.
     */
    private Node first;
    private Node last;
    private int count;

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            // первый становится новым
            this.first = newNode;
            // последний тоже ссылается на новый, т.к. больше ничего нет
            this.last = newNode;
        } else {
            // слудующий после последнего - новый узел
            last.next = newNode;
            // последний ссылается на новый, т.е. новый теперь последний.
            last = newNode;
        }
        count++;
    }

    @Override
    public int get(int index) {
        if (index < count && index > -1) {
            Node current = first;
            // отсчитываем эелементы до индекса, который ищем
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            // когда вышли из цикла, то берём значение последнего узла
            return current.value;
        }
        System.err.println("Out of list");
        return -1;
    }

    @Override
    public void removeAt(int index) {
        Node current = first;
        int step = 0;

        if (step == index) {
            current = current.next;
            first = current;
            count--;
            return;
        }

        while (step < index && step <= count) {
            step++;
            if (step == 1) {
                first.next = first.next.next;
            } else {
                current = current.next;
            }
        }
        count--;
    }

    @Override
    public int indexOf(int element) {
        int step = 0;
        Node current = first;
        while (current.value != element && current.next != null) {
            current = current.next;
            step++;
        }
        return step;
    }

    @Override
    public int lastIndexOf(int element) {
        Node current = first;
        int lastIndex = 0;
        int index = -1;
        while (current.next != null) {
            index++;
            if (current.value == element) {
                lastIndex = index;
            }
            current = current.next;
        }
        if (current.next == null && last.value == element) {
            lastIndex = ++index;
        }
        return lastIndex;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(int element) {
        Node current = first;
        boolean flag = true;

        while (current.value != element && current.next != null) {
            current = current.next;
            flag = false;
        }

        if (current.value == element) {
            flag = true;
        }

        return flag;
    }

    @Override
    public void removeFirst(int element) {
        Node current = first;

        if (current.value == element) {
            first = first.next;
            return;
        }

        // цикл доходит только до предыдущего елемента, от которого нужно удалить.
        while (current.next != null && current.next.value != element) {
            current = current.next;
        }

        if (current.next != null) {
            // перебросили узел через элемент
            current.next = current.next.next;
        }

        if (current.next == null) {
            last = current;
        }
        count--;
    }

    @Override
    public void removeLast(int element) {
        Node current = first;
        int indexCount = 0;
        int lastOccurrence = lastIndexOf(element);
        while (indexCount < lastOccurrence - 1) {
            indexCount++;
            current = current.next;
        }
        if (current.next.value == element) {
            current.next = current.next.next;
        }
    }

    @Override
    public void removeAll(int element) {
        Node current = first;
        if (current.value == element) {
            current = current.next;
            first = current;
        }
        while (current.next != null) {
            if(current.next.value != element) {
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }
}
