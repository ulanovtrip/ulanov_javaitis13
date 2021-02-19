package HomeWork1;

/*
 *
 * Необходимо написать метод, который принимает на вход рандомный массив( из пункта 1.1) и числа k и l,
 * после чего убирает k чисел начиная с l той позиции,
 * передаёт управление в сторонний метод, который вывод на экран элементы массива кратные 20.
 * */

import java.util.Scanner;

public class Task_1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numK = scanner.nextInt();
        int numL = scanner.nextInt();
        changeArray(Task1.getArray(20), numK, numL);
    }

    public static void changeArray(int[] array, int numK, int numL) {
        for (int i = numL; i < numK + numL; i++) {
            array[i] = -1;
        }
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 20 == 0) {
                System.out.println(array[i]);
            }
        }
    }
}
