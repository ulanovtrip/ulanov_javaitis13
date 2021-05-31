package multithreading.itis.executors;


// объекты данного интерфейса позволяют выполнять какую-либо задачу в побочном потоке
public interface TaskExecutor {

    /**
     * Запускает задачу в побочном потоке
     * @param task это объект, в котором содержится реализация run(), именно эта реализация представляем собой задачу
     */

    void submit(Runnable task);
}
