package stuctures.linkedlist;

import stuctures.linkedlist.node.Node;

public class Main {
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(15);
        Node c = new Node(20);
        Node d = new Node(30);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        Node current = a;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
    }
}
