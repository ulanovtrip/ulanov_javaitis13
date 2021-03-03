package linkedlist.list;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(4);
        linkedList.add(43);
        linkedList.add(14);
        linkedList.addToBegin(55);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
        //System.out.println(linkedList.get(4));
        System.out.println("Size: " + linkedList.size());
        System.out.println("+++++++++++++++++++++++++++++");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++");


        LinkedList list2 = new LinkedList();
        list2.add(77);
        list2.add(88);
        list2.add(99);
        list2.addToBegin(78);
        list2.addToBegin(777);

        //LinkedList.LinkedListIterator iterator = list2.new LinkedListIterator();
        LinkedList.LinkedListIterator iterator = list2.iterator();

        while (iterator.nasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
