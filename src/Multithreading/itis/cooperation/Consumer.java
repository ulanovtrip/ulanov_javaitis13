package Multithreading.itis.cooperation;

public class Consumer extends Thread {

    private final Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (product) {
                while (!product.isProduced()) {
                    System.out.println("Consumer is waiting!");
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
                System.out.println("Consumer consumed!");
                product.consume();
                product.notify();
            }
        }
    }
}
