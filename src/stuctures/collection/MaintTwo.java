package stuctures.collection;

import stuctures.collection.linkedlist.LinkedList;

public class MaintTwo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(2);
        list.add(5);
        list.add(5);
        list.add(1);

        list.removeAll(2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
