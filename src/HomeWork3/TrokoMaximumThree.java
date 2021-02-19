package HomeWork3;

/*
при таком вводе будет 0, это неверно
-1
-4
-2
 */


import java.util.Scanner;

public class TrokoMaximumThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = 0, b = 0, c = 0, d = 0;

        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        if (a > d) {
            d = a;
        }

        if (b > d) {
            d = b;
        }

        if (c > d) {
            d = c;
        }

        System.out.println(d);
    }
}
