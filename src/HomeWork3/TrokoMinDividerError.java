package HomeWork3;

import java.io.PrintWriter;
import java.util.Scanner;

/*   4 - */

public class TrokoMinDividerError {
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int d = 2; d < N / d; d++) {
            if (N % d == 0) {
                N = d;
                break;
            }
        }
        out.print(N);
        out.flush();
    }
}
