package patterns.consumer_producer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();

        Consumer consumer = new Consumer(product);
        Producer producer = new Producer(product);

        Scanner scanner = new Scanner(System.in);

        // стартуем потоки
        producer.start();
        consumer.start();
    }
}
