package multithreading.itis.executors;

/*
Реализация, которая для каждой задачи создаёт новый поток
Плюс - простота реализации.
Минус - тяжёлые операции для VM по созданию и завершению потоков.
 */

public class ThreadPerTaskImpl implements TaskExecutor {

    @Override
    public void submit(Runnable task) {
        Thread thread = new Thread(task);
        thread.start();
    }
}
