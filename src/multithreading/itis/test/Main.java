package multithreading.itis.test;

public class Main {
    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();

        threadService.submit(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });
    }
}
