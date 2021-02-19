package HomeWork3;

import java.io.PrintWriter;
import java.util.Scanner;

public class TrokoSimpleNumError {
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int d = 2;
        int res = 0;

        while (N >= 1) {
            if (N % d == 0) {
                res++;
                N /= d;
                while (N % d == 0)
                    N /= d;
            }
            d++;
            if (res >= 2) {
                out.print("YES");
                break;
            }
        }

        if (res < 2)
            out.print("NO");

        out.flush();
    }
}
