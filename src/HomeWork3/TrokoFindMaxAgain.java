package HomeWork3;

import java.util.Scanner;

/*
2 -1 2 - будет ошибка
* */

public class TrokoFindMaxAgain {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a = 0, b = 0, c = 0, d = 0;

        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        if ((c <= b && b < a) || (b <= c && c < a)) {
            System.out.println(a);
        }
        if ((a <= c && c < b) || (c <= a && a < b)) {
            System.out.println(b);
        }
        if ((a <= b && b < c) || (b <= a && a < c)) {
            System.out.println(c);
        }
    }
}
