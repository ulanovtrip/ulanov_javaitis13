package HomeWork3;
//https://informatics.mccme.ru/mod/statements/view.php?id=7437&chapterid=246#1

import java.util.Scanner;

public class SquareTables {
    public static int[][] matrixFirst;
    public static int[][] matrixSecond;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeSearchMatrix = scanner.nextInt();
        initMatrix(sizeSearchMatrix);
        System.out.println(findEqualsElements(sizeSearchMatrix));
    }

    public static void initMatrix(int size) {
        matrixFirst = new int[size][size];
        matrixSecond = new int[size][size];

        int lastInRow = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixFirst[i][j] = ++lastInRow;
            }
        }
        lastInRow = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixSecond[j][i] = ++lastInRow;
            }
        }
    }

    public static String findEqualsElements(int sizeSearchMatrix) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < sizeSearchMatrix; i++) {
            for (int j = 0; j < sizeSearchMatrix; j++) {
                int elemFromFirsMatrix = matrixFirst[i][j];
                int elemFromSecondMatrix = matrixSecond[i][j];
                if (elemFromFirsMatrix == elemFromSecondMatrix) {
                    builder.append(elemFromFirsMatrix + " ");
                }
            }
        }
        return builder.toString();
    }
}
