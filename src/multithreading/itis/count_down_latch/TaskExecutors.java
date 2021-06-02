package multithreading.itis.count_down_latch;


/**
 * Класс, который будет предоставлять различный реализации TaskExecutor-ов
 */
public class TaskExecutors {

    public static TaskExecutor threadPool(int threadsCount) {
        return new ThreadPoolImpl(threadsCount);
    }
}
