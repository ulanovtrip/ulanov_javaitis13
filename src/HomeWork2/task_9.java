package HomeWork2;

/*
 * Вводится n чисел. Проверить, что среди них существует ровно два таких числа, что длина (количество цифр)
 *  каждого из них равна 3 или 5, а их цифры либо все четные, либо все нечетные.*/

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class task_9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfElements = new LinkedList<>();

        while (scanner.hasNext()) {
            int currentNum = scanner.nextInt();
            if (currentNum == -1) {
                break;
            }
            listOfElements.add(currentNum);
        }

        int counterOfFoundNumbers = 0;
        for (int num : listOfElements) {
            if (checkLengthNumber(num)) {
                if (checkOddOrEven(num)) {
                    counterOfFoundNumbers++;
                }
            }
        }

        System.out.println(counterOfFoundNumbers > 2);
    }

    public static boolean checkLengthNumber(int number) {
        int counter = 0;
        while (number > 0) {
            counter++;
            number = number / 10;
        }

        if (counter == 3 || counter == 5) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkOddOrEven(int number) {

        int lengthOfNumber = 0;
        int foundOdd = 0;
        int foundEven = 0;
        while (number > 0) {
            lengthOfNumber++;
            int divisor = number % 10;

            if ((divisor % 2) == 0) {
                foundEven++;
            } else {
                foundOdd++;
            }

            number = number / 10;
        }

        return lengthOfNumber == foundOdd || lengthOfNumber == foundEven;
    }
}
