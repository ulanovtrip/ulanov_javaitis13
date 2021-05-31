package multithreading.itis.executors;

public class Main {
    public static void main(String[] args) {

        //TaskExecutor executor = TaskExecutors.threadPerTask();
        //TaskExecutor executor = TaskExecutors.workerThread();
        TaskExecutor executor = TaskExecutors.threadPool(2);


        // первая задача
        executor.submit(() -> {
            for (int i = 2; i < 500_000_000; i++) {

                if (isPrime(i)) {
                    System.out.println(Thread.currentThread().getName() + i + " is simple!");
                }
            }
        });

        // вторая задача
        executor.submit(() -> {
            for (int i = 500_000_000; i < 1_000_000_000; i++) {

                if (isPrime(i)) {
                    System.out.println(Thread.currentThread().getName() + i + " is simple!");
                }
            }
        });

        // третья задача
        executor.submit(() -> {
            for (int i = 1_000_000_000; i < 2_000_000_000; i++) {
                if (isPrime(i)) {
                    System.out.println(Thread.currentThread().getName() + i + " is simple!");
                }
            }

        });

        // третья задача
        executor.submit(() -> {
            for (int i = 2_000_000_000; i < Integer.MAX_VALUE; i++) {
                if (isPrime(i)) {
                    System.out.println(Thread.currentThread().getName() + i + " is simple!");
                }
            }

        });
    }

    private static boolean isPrime(int number) {

        if (number == 2 || number == 3) {
            return true;
        }

        for (int j = 2; j * j <= number; j++) {
            if (number % j == 0) {
                return false;
            }
        }

        return true;
    }
}
