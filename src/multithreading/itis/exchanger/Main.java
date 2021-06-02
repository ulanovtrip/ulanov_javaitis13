package multithreading.itis.exchanger;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<List<Integer>> exchanger = new Exchanger<>();
        ListPrinter printer = new ListPrinter(exchanger);
        PrimesThread primes = new PrimesThread(0, 2_100_000_000, 10_000_000, exchanger);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        new Thread(primes).start();
        new Thread(printer).start();
    }
}
