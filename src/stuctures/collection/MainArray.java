package stuctures.collection;

import stuctures.collection.arraylist.ArrayList;
import stuctures.collection.base.Iterator;
import stuctures.collection.base.List;

public class MainArray {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(1);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11);
        System.out.print("Before: ");
        printArray(arrayList);
        System.out.print("After: ");
        arrayList.removeFirst(2);
        printArray(arrayList);
        System.out.println("Is contain 15: " + arrayList.contains(15));
        System.out.println("Is contain 1: " + arrayList.contains(1));
        System.out.println("Is contain 11: " + arrayList.contains(11));
        System.out.println("Index of 3: " + arrayList.indexOf(3));
        System.out.println("Index of 12: " + arrayList.indexOf(12));
        System.out.println("Index of 11: " + arrayList.indexOf(11));
        System.out.println("Last index of 1: " + arrayList.lastIndexOf(1));
        System.out.println("Last index of 12: " + arrayList.lastIndexOf(12));

        System.out.print("Before: ");
        printArray(arrayList);
        System.out.print("After: ");
        arrayList.removeAt(4);
        printArray(arrayList);

        System.out.print("Before: removeLast ");
        printArray(arrayList);
        System.out.print("After: removeLast ");
        arrayList.removeLast(1);
        printArray(arrayList);

        System.out.print("Before: removeAll ");
        printArray(arrayList);
        System.out.print("After: removeAll ");
        arrayList.removeAll(1);
        printArray(arrayList);
    }

    private static void printArray(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
