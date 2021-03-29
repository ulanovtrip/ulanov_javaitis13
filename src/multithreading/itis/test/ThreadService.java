package multithreading.itis.test;

public class ThreadService {

    public void submit(Runnable task) {
        Thread thread = new Thread(task);
        thread.start();
    }
}
