package HomeWork3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddsAndEvens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();

        int step = 0;
        while (step < 3) {
            step++;
            inputList.add(scanner.nextInt());
        }

        int countOfOdd = 0;
        int countOfEven = 0;

        for (Integer current : inputList) {
            if (current % 2 == 0) {
                countOfEven++;
            } else {
                countOfOdd++;
            }
        }

        if (countOfEven > 0 && countOfOdd > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
