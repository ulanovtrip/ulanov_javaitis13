package multithreading.itis.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;


public class PrimesThread implements Runnable {
    private int from;
    private int to;
    private int partSize;
    private Exchanger<List<Integer>> producer;

    public PrimesThread(int from, int to, int partSize, Exchanger<List<Integer>> producer) {
        this.from = from;
        this.to = to;
        this.partSize = partSize;
        this.producer = producer;
    }

    private boolean isPrimeSum(int number) {
        int sum = 0;
        // 71113 = 7 + 1 + 1 + 1 + 3 = 13 - простое
        // считаем сумму цифр числа
        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }

        if (sum == 2 || sum == 3) {
            return true;
        }

        for (int i = 2; i * i <= sum; i++) {
            if (sum % i == 0) {
                return false;
            }
        }

        return true;
    }


    @Override
    public void run() {
        int currentIndex = 0;
        List<Integer> currentPart = new ArrayList<>();
        // прохожу весь диапазон чисел
        for (int i = from; i < to; i++) {
            // проверяю, является ли сумма цифр данного числа простым числом
            if (isPrimeSum(i)) {
                // если да, то добавляю в список
                currentPart.add(i);
            }
            // если у меня набралось partSize-чисел
            if (currentIndex == partSize) {
                try {
                    System.out.println("Primes - отдает результат на печать");
                    producer.exchange(currentPart);
                    System.out.println("Primes - работает дальше");
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                // заново создаем список
                currentPart = new ArrayList<>();
                currentIndex = 0;
            }

            currentIndex++;
        }
    }
}
