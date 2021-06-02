package multithreading.itis.count_down_latch;

import java.util.Deque;
import java.util.LinkedList;

public class ThreadPoolImpl implements TaskExecutor {
    // массив потоков, которые все время работают
    // создаются единожды и завершается единожды
    private final WorkerThread threads[];

    // очередь задач, которые необходимо выполнить в побочном потоке
    private final Deque<Runnable> tasks;

    public ThreadPoolImpl(int threadsCount) {
        this.tasks = new LinkedList<>();
        // создаю массив нужного количества
        this.threads = new WorkerThread[threadsCount];

        for (int i = 0; i < threads.length; i++) {
            // создали поток
            threads[i] = new WorkerThread("poolWorker-" + i);
            // запустили поток
            threads[i].start();
        }
    }

    private class WorkerThread extends Thread {
        public WorkerThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            // взять задачу и выполнить ее, поскольку run - это действия в одном из потоков pool-а
            // то каждая задача будет выполнена именно в этом побочном потоке
            Runnable currentTask; // текущая задача, которую необходимо выполнить
            // каждый поток threads работает бесконечно
            while (true) {
                // блокируем очередь задач
                synchronized (tasks) {
                    // пока очередь задач пустая
                    while (tasks.isEmpty()) {
                        try {
                            // уходим в ожидание - текущий поток ждет, пока не появятся новые задачи
                            tasks.wait();
                        } catch (InterruptedException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                    // забрали очередную задачу
                    currentTask = tasks.poll();
                }
                // выполняем ее
                currentTask.run();
            }
        }
    }
    @Override
    public void submit(Runnable task) {
        // добавляем задачу в очередь
        // очень важно, чтобы когда мы с вами добавляем задачу, ее нельзя оттуда забрать
        synchronized (tasks) {
            tasks.add(task);
            // оповещаем поток workerThread о том, что появилась новая задача
            // и ее необходимо выполнить
            tasks.notify();
        }
    }
}
