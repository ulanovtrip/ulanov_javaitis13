package HomeWork2;

/*
Проверить, что во входной последовательности целых чисел существует ровно два четных по значению локальных максимума
Вводятся целые k, m.
Вывести целые числа между k и m, которые делятся на 3.
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        List<Integer> input = readInput();
        finderMaximums(input);
    }

    public static void finderMaximums(List<Integer> input) {

        int maximumK = 0;
        int maximumM = 0;
        int countKMax = 0;
        int contMMax = 0;

        for (int i = 0; i < input.size() - 1; i++) {
            int currentNum = input.get(i);

            if (currentNum < input.get(i + 1) && countKMax < 3) {
                maximumK = currentNum;
                countKMax++;
            } else {
                for (int j = i + 1; j < input.size() - 1; j++) {
                    int current = input.get(j);
                    if (current < input.get(j + 1) && contMMax < 3) {
                        maximumM = current;
                        contMMax++;
                    }
                }
            }
        }

        if (maximumK % 2 == 0 && maximumM % 2 == 0) {
            System.out.println("Ok");
        }
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
}
