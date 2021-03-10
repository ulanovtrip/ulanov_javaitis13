package patterns.factory_method;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DocumentsPrinter printer = new DocumentsPrinter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - если нужна справка");
        System.out.println("2 - если нужно заявление");

        int type = scanner.nextInt();

        if (type == 1) {
            printer.setGenerator(new CertificatesGenerator());
        } else {
            printer.setGenerator(new StatementsGenerator());
        }

        // после вызова nextInt()
        // чтобы перейти на след. строку после ввода цифры
        scanner.nextLine();

        String text = scanner.nextLine();
        printer.printDocument(text);
    }
}
