package HomeWork3;

//https://informatics.mccme.ru/mod/statements/view.php?id=7437#1

import java.util.Scanner;

public class NextAndPrevious {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int nextNumber = inputNumber + 1;
        int previousNumber = inputNumber - 1;
        System.out.printf("The next number for the number %d is %d.\n", inputNumber, nextNumber);
        System.out.printf("The previous number for the number %d is %d.", inputNumber, previousNumber);
    }
}
