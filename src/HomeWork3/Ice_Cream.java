package HomeWork3;

import java.util.Scanner;

public class Ice_Cream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberK = scanner.nextInt();



//        if (numberK >= 19) {
//            numberK %= 10;
//           getAnswer(numberK);
//           return;
//        }

        getAnswer(numberK);
    }

    public static void getAnswer(int numberK) {
        boolean flag = false;

        if (numberK == 3 || numberK == 5) {
            flag = true;
        } else if (numberK < 3 || numberK == 4) {
            flag = false;
        } else if (numberK % 3 == 0 || numberK % 5 == 0 || numberK % 8 == 0) {
            flag = true;
        } else if ((numberK - 5) % 3 == 0 || (numberK - 3) % 5 == 0) {
            flag = true;
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
