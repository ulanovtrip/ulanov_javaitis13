package stuctures.collection.linkedlist;

import stuctures.collection.base.Iterator;
import stuctures.collection.base.List;

public class TestRemoveAll {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(21);
        list.add(31);
        list.add(21);
        list.add(41);
        list.add(51);
        list.add(21);

        printArray(list);

        list.removeAll(21);

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
