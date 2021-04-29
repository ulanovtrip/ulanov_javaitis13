package object_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Human ivan = new Human("Ivan", "Ulanov", 37, 1.82);
        Human isak = new Human("Ivan", "Ulanov", 37, 1.82);
        System.out.println(ivan);

        System.out.println(ivan == isak);

        Scanner scanner = new Scanner(System.in);
        System.out.println(ivan.equals(isak));
        System.out.println(ivan.equals(scanner));
        System.out.println("--------------------------------------------");

        EqualsUtils equalsUtils = new EqualsUtils();
        System.out.println(equalsUtils.allEquals("Hi", "Hi", "How are", "you"));
        System.out.println(equalsUtils.allEquals("Hi", "Hi"));
        System.out.println("--------------------------------------------");

        System.out.println(equalsUtils.allEquals(ivan, isak));
    }
}
