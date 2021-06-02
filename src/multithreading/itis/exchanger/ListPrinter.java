package multithreading.itis.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ListPrinter implements Runnable {

    private Exchanger<List<Integer>> consumer;

    public ListPrinter(Exchanger<List<Integer>> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            List<Integer> currentList = null;
            try {
                // ждем готовый список от exchanger
                System.out.println("Printer - ждет, пока не выполнится расчет");
                currentList = consumer.exchange(null);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Printer - получены данные в размере - " + currentList.size());
        }

    }
}
