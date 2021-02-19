package HomeWork3;

import java.io.PrintWriter;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int numA = scanner.nextInt();
        int numB = scanner.nextInt();

        writer.println(numA + numB);
        writer.flush();
    }
}
