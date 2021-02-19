package HomeWork3;

import java.util.Scanner;

public class ChipsFishki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberK = scanner.nextInt();

        if (numberK <= 0 || numberK > 30_000) {
            System.out.println("NO");
            return;
        }

        int forthPartOfTable = numberK / 4;

        int sideAB = forthPartOfTable + 1;
        int sideBC = sideAB - 2;
        int sideCD = sideAB;
        int sideDA = sideBC;

        int sumOfCellsCurrentTable = sideAB + sideBC + sideCD + sideDA;

        if (sumOfCellsCurrentTable > numberK || sumOfCellsCurrentTable < numberK) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
