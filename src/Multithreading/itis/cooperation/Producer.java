package Multithreading.itis.cooperation;

public class Producer extends Thread {
    private final Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (product) {
                while (!product.isConsumed()) {
                    System.out.println("Producer is waiting!");
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
                System.out.println("Producer is prepared");
                product.produce();
                product.notify();
            }
        }
    }
}
