package stuctures.linkedlist.node;

public class Node {
    private int value;
    // объектная переменная (адрес объекта), указывает на объект
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
