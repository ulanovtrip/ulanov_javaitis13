package multithreading.itis.executors;

// класс, который будет поставлять необходимый объект
// предоставляет различные реализации TaskExecutor
public class TaskExecutors {

    // фабричный метод
    public static TaskExecutor threadPerTask() {
        return new ThreadPerTaskImpl();
    }

    public static TaskExecutor workerThread() {
        return new WorkerThreadImpl();
    }

    public static TaskExecutor threadPool(int threadCount) {
        return new ThreadPoolImpl(threadCount);
    }
}
