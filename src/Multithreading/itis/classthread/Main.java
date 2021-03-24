package Multithreading.itis.classthread;

public class Main {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());

        HenThread hen = new HenThread();
        EggThread egg = new EggThread();

        // start thread
        hen.start();
        egg.start();

        // method for waiting, this method will start before main till to die
        try {
            hen.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 500; i++) {
            System.out.println("Human");
        }
    }
}
