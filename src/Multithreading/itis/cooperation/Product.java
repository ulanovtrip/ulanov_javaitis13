package Multithreading.itis.cooperation;

public class Product {

    private boolean isReady = false;

    public boolean isProduced() {
        return isReady;
    }

    public boolean isConsumed() {
        return !isReady;
    }

    public void produce() {
        this.isReady = true;
    }

    public void consume() {
        this.isReady = false;
    }
}
