package generics.linked_stack;

public class LinkedStackTest {

    public static void main(String[] args) {

        LinkedStack<String> lss = new LinkedStack<>();

        for (String s : "Phasers on fun!".split(" ")) {
            lss.push(s);
        }

        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }
}
