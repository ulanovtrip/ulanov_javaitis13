package HomeWork2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinderSimpleSum {

    public static void main(String[] args) {
        List<Integer> input = readInput();

        int counterOfSimple = 0;

        for (Integer num : input) {
            int sumOfCurrentElem = digitsSum(num);

            if (isSimple(sumOfCurrentElem)) {
                counterOfSimple++;
            }
        }

        System.out.println(counterOfSimple);
    }

    public static List<Integer> readInput() {
        List<Integer> inputDigits = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                int current = scanner.nextInt();
                if (current == -1) {
                    break;
                } else {
                    inputDigits.add(current);
                }
            }
        } catch (Exception e) {
            System.out.println("Input ERROR!!!");
        }

        return inputDigits;
    }

    public static int digitsSum(int number) {
        int sum = 0;

        while (number > 0) {
            int divisor = number % 10;
            sum += divisor;
            number = number / 10;
        }

        return sum;
    }

    public static boolean isSimple(int number) {
        boolean flag = true;

        if (number == 2 || number == 3) {
            return true;
        }

        int start = 2;

        while ((start * start) < number) {
            if (number % start == 0) {
                flag = false;
                break;
            }
            start += 1;
        }
        return flag;
    }
}
