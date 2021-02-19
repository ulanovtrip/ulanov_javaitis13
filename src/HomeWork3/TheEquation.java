package HomeWork3;

import java.util.Scanner;

//https://ru.stackoverflow.com/questions/1090776/%D0%A0%D0%B5%D1%88%D0%B8%D1%82%D0%B5-%D0%B2-%D1%86%D0%B5%D0%BB%D1%8B%D1%85-%D1%87%D0%B8%D1%81%D0%BB%D0%B0%D1%85-%D1%83%D1%80%D0%B0%D0%B2%D0%BD%D0%B5%D0%BD%D0%B8%D0%B5-ax-b-0

public class TheEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int memberA = scanner.nextInt();
        int memberB = scanner.nextInt();

        if (memberA == 0 & memberB == 0) {
            System.out.println("INF");
        } else if (memberA == 0 || (memberB % memberA) != 0) {
            System.out.println("NO");
        } else {
            System.out.println((memberB * -1) / memberA);
        }
    }
}
