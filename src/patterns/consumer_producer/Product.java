package patterns.consumer_producer;

public class Product {

    // true - значит можно использовать
    private boolean isReady;

    // продукт готов, когда его можно использовать
    public boolean isProduced() {
        return isReady;
    }

    // не готов к использованию, т.е. использован
    public boolean isConsumed() {
        return !isReady;
    }

    // готовим, приводим в готовность
    public void produce() {
        this.isReady = true;
    }

    public void consume() {
        this.isReady = false;
    }
}
