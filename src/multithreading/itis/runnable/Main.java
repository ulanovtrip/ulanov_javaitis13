package multithreading.itis.runnable;

public class Main {
    public static void main(String[] args) {
        Trex trex = new Trex();
        Thread thread = new Thread(trex);

        thread.start();
    }
}
