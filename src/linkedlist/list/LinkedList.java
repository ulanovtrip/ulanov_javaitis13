package linkedlist.list;

public class LinkedList {

    // вложенный класс, чтобы инкапсулировать
    private static class Node {
        // модификаторы не нужны, т.к. в одной области находятся
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public class LinkedListIterator {
        private Node current;

        public LinkedListIterator() {
            this.current = first;
        }

        public boolean nasNext() {
            return current != null;
        }

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

    /*
    public void add(int value) {
        // создаём новый узел
        Node newNode = new Node(value);
        // если в списке ещё нет элементов
        if (first == null) {
            // значит он и будет первый
            first = newNode;
        } else {
            // если уже есть, то нужно добраться до конца и положить в конец
            Node current = first;
            // пока есть ссылка на следующий узел
            while (current.next != null) {
                // переходим к следующему
                current = current.next;
            }
            // вышли из цикла когда встали на последнем эелементе, присвоим его полю next ссылку на созданный узел.
            // следующий после последнего - новый узел
            current.next = newNode;
        }
    }
    */

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

    public void addToBegin(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            this.first = newNode;

        } else {
            newNode.next = first;
            first = newNode;
        }
        this.last = newNode;
        count++;
    }

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

    public int size() {
        return count;
    }

    public LinkedListIterator iterator() {
        return new LinkedListIterator();
    }
}
