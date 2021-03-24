package Multithreading.itis.resources;

public class Human extends Thread {

    private String name;
    private final CreditCard creditCard;

    public Human(String name, CreditCard creditCard) {
        this.name = name;
        this.creditCard = creditCard;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

            // если какой-то поток зашёл в блок synchronized, то он занял мьютекс
            synchronized (creditCard) {
                if (creditCard.getAmount() > 0) {
                    System.out.println(name + " buying... ");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException(e);
                    }
                    if (creditCard.buy(10)) {
                        System.out.println(name + " bought!");
                    } else {
                        System.out.println(name + "...I don't understand..can't buy...");
                    }
                }
            }
        }
    }
}
