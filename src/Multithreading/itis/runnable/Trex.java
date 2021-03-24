package Multithreading.itis.runnable;

public class Trex implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("T-rex");
        }
    }
}
