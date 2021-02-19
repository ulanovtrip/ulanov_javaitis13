package HomeWork1;

/*
 * 1.4)
 * Необходимо написать метод, который принимает на вход рандомный массив( из пункта 1.1) и число k,
 * после чего вставляет на k тую позицию в массиве числа от 1 до k,
 * а затем передаёт управление в другой метод, который вывод на экран только нечётные числа из массива.
 * */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kPosition = scanner.nextInt();
        int[] inputArray = Task1.getArray(6);
        System.out.println(Arrays.toString(inputArray));
        changeMatrix(inputArray, kPosition);
    }

    public static void changeMatrix(int[] inputArray, int kPosition) {
        Random random = new Random();

        for (int i = 0; i < inputArray.length; i++) {
            if (i == kPosition) {
                inputArray[i] += 1 + random.nextInt(kPosition);
                break;
            }
        }
        printOdds(inputArray);
    }

    public static void printOdds(int[] array) {
        System.out.println("Print only Odds:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
