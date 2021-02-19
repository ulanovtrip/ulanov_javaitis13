package HomeWork1;

/*
 * 1.3) Необходимо написать метод, считывающий с клавиатуры матрицу размером N на M,
 * после чего написать ещё один метод, который принимает это матрицу и считает сумму элементов на главной диагонали.
 * */

import java.util.Scanner;

public class Task_3_1 {
    public static void main(String[] args) {
        int[][] outputMatrix = fillMatrix(readMatrix());
        System.out.println(sumDiagonal(outputMatrix));
    }

    public static int[][] readMatrix() {
        Scanner scanner = new Scanner(System.in);
        int sideN = scanner.nextInt();
        int sideM = scanner.nextInt();

        return new int[sideN][sideM];
    }

    public static int[][] fillMatrix(int[][] matrix) {
        int filler = 10;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = filler++;
            }
        }
        return matrix;
    }

    public static int sumDiagonal(int[][] matrix) {
        int principal = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    principal += matrix[i][j];
                }
            }
        }
        return principal;
    }
}
