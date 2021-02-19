package HomeWork2;

/*
https://github.com/SimonOnBoard/java-itis/blob/master/src/Task11.java
 * Вводится целое 2 < k < 9, затем вводится целое число n, которое можно интерпретировать
 * как число в k-ичной системе счисления.
 * Сконвертировать n в десятичную систему счисления.
 * Строковые типы не используются.
 * */

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = power = scanner.nextInt();
        int nNumber = 0;

        if (power >= 2 && power < 9) {
            nNumber = scanner.nextInt();
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (nNumber > 0) {
            stringBuilder.append(nNumber % power);
            nNumber = nNumber / power;
        }

        System.out.println(stringBuilder.toString());
    }
}
