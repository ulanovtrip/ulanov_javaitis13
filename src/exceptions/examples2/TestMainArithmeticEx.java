package exceptions.examples2;

import java.util.Scanner;

public class TestMainArithmeticEx {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        MatiUtil matiUtil = new MatiUtil();

        int result = 0;
        try {
            result = matiUtil.div(x, y);

        } catch (ArithmeticException e) {
            System.out.println("Division by ZORRO!");
            System.exit(-1);
        }
        System.out.println(result);
    }
}
