package generics.itis.part2.linkedlist;

public class TestMain {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(21);
        list.add(31);
        list.add(41);
        list.add(51);
        list.removeAt(1);
        System.out.println();
    }
}
