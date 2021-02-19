package HomeWork3;

import java.util.Scanner;

public class Oranges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();

        if (inputNumber <= 100) {
            String word = getLocalized(inputNumber);
            System.out.println(inputNumber + " " + word);
        } else if (inputNumber > 100) {
            String word = getLocalized(inputNumber % 100);
            System.out.println(inputNumber + " " + word);
        }
    }

    public static String getLocalized(int inputNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        int lastDigit = inputNumber % 10;

        if (inputNumber > 10 && inputNumber < 20) {
            stringBuilder.append("bochek");
        } else if (inputNumber % 10 == 1) {
            stringBuilder.append("bochka");
        } else if (lastDigit == 2 || lastDigit == 3 || lastDigit == 4) {
            stringBuilder.append("bochki");
        } else {
            stringBuilder.append("bochek");
        }

        return stringBuilder.toString();
    }
}
