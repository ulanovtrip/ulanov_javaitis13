package HomeWork1;

/*
 * 1.2) Необходимо написать метод, создающий внутри себя копию массива,
 * и прибавляющий каждому 3х значному числу обратное к нему число.
 * Обратное пример: к число 123 обратно 321.
 * После чего оба массива будут переданы в метод,
 * который выводит их содержимое на экран и выводит на экран первый элемент в котором они отличаются.
 * */

import java.util.Arrays;

public class Task_1_2 {
    public static void main(String[] args) {
        int[] inputArray = Task1.getArray(10);
        copyOfArray(inputArray);
    }

    public static void copyOfArray(int[] array) {
        int[] copiedArray = new int[array.length];

        for (int i = 0; i < copiedArray.length; i++) {
            if (isTriple(array[i])) {
                int reversed = reverseNum(array[i]);
                copiedArray[i] = reversed + array[i];
            } else {
                copiedArray[i] = array[i];
            }
        }
        printBoth(array, copiedArray);
    }

    public static void printBoth(int[] input, int[] copy) {
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(copy));
    }

    public static int reverseNum(int palindrome) {
        int reverse = 0;
        while (palindrome > 0) {
            int remainder = palindrome % 10; //вытащили последнее число из многозначного и сохранили
            reverse = reverse * 10 + remainder; //доводим до нужной разрядности и прибавим к концу последнее число
            palindrome = palindrome / 10; //уменьшим разрядность, без последнего числа
        }
        return reverse;
    }

    public static boolean isTriple(int elem) {
        int step = 0;

        while (elem > 0) {
            step++;
            elem /= 10;
        }

        if (step == 3) {
            return true;
        } else {
            return false;
        }
    }
}
