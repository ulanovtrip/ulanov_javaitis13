package generics.itis.part2.linkedlist;

import generics.itis.part1.collections.List;

public class LinkedList<D> implements List<D> {

    // вложенный класс, чтобы инкапсулировать
    // тут class Node<C> - объявление параметризованного типа
    private static class Node<C> {
        // модификаторы не нужны, т.к. в одной области находятся
        C value;
        Node<C> next;

        public Node(C value) {
            this.value = value;
        }
    }

    /*
    Чтобы иметь информация о всём связном списке нам нужно хранить ссылку только на первый элемент.
     */
    // Node<C> - тут использование параметризованного типа
    private Node<D> first;
    private Node<D> last;
    private int count;

    @Override
    public void add(D value) {
        Node<D> newNode = new Node<>(value);
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
    public D get(int index) {
        if (index < count && index > -1) {
            Node<D> current = first;
            // отсчитываем эелементы до индекса, который ищем
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            // когда вышли из цикла, то берём значение последнего узла
            return current.value;
        }
        System.err.println("Out of list");
        return null;
    }

    @Override
    public void removeAt(int index) {
        Node current = first;

        if (current == null) {
            System.out.println("List is Empty!");
            return;
        }

        if (index + 1 > count) {
            System.out.println("Wrong number of Index!");
            return;
        }

        int step = 0;

        // для первого эелемента
        if (step == index) {
            current = current.next;
            first = current;
            count--;
            return;
        }

        while (step < index && step <= count) {
            step++;
            // проверка равен ли шаг нужному индексу
            if (step == index) {
                // если да, то перекинем через элемент
                current.next = current.next.next;
            } else {
                // если не равен, то текущий узел становится следующим
                current = current.next;
            }
        }
        count--;
    }

    @Override
    public int indexOf(D element) {
        int step = 0;
        Node<D> current = first;
        while (current.value != element && current.next != null) {
            current = current.next;
            step++;
        }

        if (current.next == null && step == 0) {
            return -1;
        } else {
            return step;
        }
    }

    @Override
    public int lastIndexOf(D element) {
        Node<D> current = first;
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
    public boolean contains(D element) {
        Node<D> current = first;
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
    public void removeFirst(D element) {
        Node<D> current = first;

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
    public void removeLast(D element) {
        Node<D> current = first;
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
    public void removeAll(D element) {
        // TODO неправильная реализация, доделать
        Node<D> current = first;
        while (current.next != null) {
            if (current.value == element) {
                current = current.next;
                first = current;
                count--;
            } else {
                current = current.next;
                count--;
            }

            if (current.next == null && current.value == element) {
                current = null;
                first = null;
                last = null;
                count--;
                return;
            }
        }
    }
}
