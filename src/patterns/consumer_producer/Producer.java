package patterns.consumer_producer;

public class Producer extends Thread {

    private final Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {

        while (true) {
            // используем product как мьютекс
            // в блок synchronized другой поток вмешаться не может
            synchronized (product) {
                System.out.println("Producer проверяем продукт:");

                // пока product не употребили
                while (!product.isConsumed()) {
                    System.out.println("Producer ждёт, пока продукт употребят.");

                    try {
                        // wait() заставляет поток не делать ничего, пока другой поток не вызовет notify()
                        // wait освобождает мьютекс
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                }

                // представим, что продукт употребили, тогда Producer должен его подготовить.
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " Producer: " + " Product is Produce!");
                product.produce();
                // сообщаем, что продукт потреблён
                product.notify();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }
}
