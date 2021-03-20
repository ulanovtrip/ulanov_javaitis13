package stuctures.collection.linkedlist;

import stuctures.collection.base.Iterator;
import stuctures.collection.base.List;

public class TestLInkedTwo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        System.out.println("Before: ");
        printArray(list);
        System.out.println("After: ");
        list.removeAt(3);
        printArray(list);
        System.out.println("------------------------------");
        System.out.println(list.indexOf(33));
        System.out.println(list.indexOf(11));
        System.out.println(list.indexOf(22));
        list.removeFirst(11);
        list.removeFirst(22);
        list.removeFirst(33);
        list.add(11);
        list.add(11);
        list.add(11);
        list.add(12);
        list.add(12);
        list.add(13);
        list.add(13);
        System.out.println("------------------------------");
        System.out.println("Before: ");
        printArray(list);
        System.out.println("After: ");
        list.removeAll(11);
        printArray(list);

        System.out.println("------------------------------");
        System.out.println("Before: ");
        printArray(list);
        System.out.println("After: ");
        list.removeAll(12);
        printArray(list);

        System.out.println("------------------------------");
        System.out.println("Before: ");
        printArray(list);
        System.out.println("After: ");
        list.removeAll(13);
        printArray(list);
    }

    private static void printArray(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
