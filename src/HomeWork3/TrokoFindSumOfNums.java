package HomeWork3;

import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 0 1 0 4 0 7 1 0 0 - error input
 */

public class TrokoFindSumOfNums {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int a = -1;
        int b = 0;
        int sum = 0;
        while (a != 0 || b != 0) {
            a = b;
            b = in.nextInt();
            sum = sum + b;
        }
        System.out.println(sum);
        in.close();
    }
}
