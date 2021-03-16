package stuctures.collection;

import stuctures.collection.base.Iterator;
import stuctures.collection.base.List;
import stuctures.collection.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(7);
        list.add(15);
        list.add(10);
        list.add(15);
        list.add(16);
        printArray(list);
        System.out.println("-----------------------------");
        list.removeFirst(15);
        printArray(list);
        System.out.println("-----------------------------");
        System.out.println("IndexOf " + list.indexOf(16));
        System.out.println("IndexOf " + list.indexOf(15));
        System.out.println("IndexOf " + list.indexOf(7));
        System.out.println("-----------------------------");
        System.out.println("Contains 16 " + list.contains(16));
        System.out.println("Contains 2 " + list.contains(2));
        System.out.println("Contains 7 " + list.contains(7));
        System.out.println("Contains 15 " + list.contains(15));
        System.out.println("-----------------------------");

        System.out.println("Before removeAt: ");
        printArray(list);
        list.removeAt(0);
        list.removeAt(1);
        list.removeAt(1);
        System.out.println("After removeAt: ");
        printArray(list);
        list.removeAt(0);
        System.out.println("-----------------------------");
        list.add(66);
        list.add(77);
        list.add(88);
        list.add(66);
        list.add(99);
        list.add(66);
        list.add(101);
        list.add(66);
        printArray(list);
        System.out.println("-----------------------------");
        System.out.println("Index of last 101 : " + list.lastIndexOf(101));
        System.out.println("Index of last 66: " + list.lastIndexOf(66));
        System.out.println("Index of last 77: " + list.lastIndexOf(77));
        System.out.println("Index of last 99: " + list.lastIndexOf(99));
        System.out.println();
        System.out.println("-----------------------------");

        System.out.println("Before removeLast: ");
        printArray(list);
        list.removeLast(66);
        System.out.println("After removeLast: ");
        printArray(list);
        System.out.println("-----------------------------");

        System.out.println("Before removeAll: ");
        printArray(list);
        list.removeAll(66);
        System.out.println("After removeAll: ");
        printArray(list);

//        List arrayList = new ArrayList();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//        arrayList.add(5);
//        arrayList.add(6);
//        arrayList.add(7);
//        arrayList.add(8);
//        arrayList.add(9);
//        arrayList.add(10);
//        arrayList.add(11);
//
//        arrayList.removeFirst(2);
//
//        Iterator arrayIterator = arrayList.iterator();
//
//        while (arrayIterator.hasNext()) {
//            System.out.print(arrayIterator.next() + " ");
//        }
    }

    private static void printArray(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
