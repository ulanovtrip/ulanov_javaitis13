package HomeWork1;

/*
 * Необходимо написать метод, возвращающий массив длиной N,
 * N вводится с клавиатуры, массив должен быть заполнен рандомными числами.
 * */

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] out = getArray(size);

        System.out.println(Arrays.toString(out));
    }

    public static int[] getArray(int size) {
        SecureRandom random = new SecureRandom();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200);
        }

        return array;
    }
}
