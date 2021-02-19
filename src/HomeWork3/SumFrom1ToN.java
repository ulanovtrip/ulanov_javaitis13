package HomeWork3;

import java.util.Scanner;

public class SumFrom1ToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long inputNumber = scanner.nextLong();

        if (inputNumber >= 0) {
            long chiller = (1 + inputNumber) * inputNumber;
            long counterSum = chiller / 2;
            System.out.println(counterSum);
        } else {
            long chiller = (1 + Math.abs(inputNumber)) * Math.abs(inputNumber);
            long counterSum = chiller / 2;
            System.out.println(counterSum *= -1);
        }
    }
}
