package HomeWork3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumFromThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfNumbers = new ArrayList<>();

        int countOfSteps = 0;
        while (countOfSteps < 3) {
            countOfSteps++;
            listOfNumbers.add(scanner.nextInt());
        }

        int maximum = listOfNumbers.get(0);
        for (int i = 1; i < 3; i++) {
            int currentNumber = listOfNumbers.get(i);
            if (currentNumber > maximum) {
                maximum = currentNumber;
            }
        }
        System.out.println(maximum);
    }
}
