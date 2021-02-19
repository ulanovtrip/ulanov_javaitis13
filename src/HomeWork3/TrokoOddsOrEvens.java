package HomeWork3;

import java.util.Scanner;

public class TrokoOddsOrEvens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = 0, b = 0, c = 0, _a = 0, _b = 0, _c = 0;

        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        _a = a % 2;
        _b = b % 2;
        _c = c % 2;
        if (_a == _b && _b == _c)
            System.out.println("NO");
        else
            System.out.println("YES");

    }
}
