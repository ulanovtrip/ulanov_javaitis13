package multithreading.itis.executors;


import java.util.Deque;
import java.util.LinkedList;

// здесь будет один рабочий поток
public class ThreadPoolImpl implements TaskExecutor {

    // массив потоков, который будут выполнять задачи, которые в него поступают, они постоянно работают
    // он создаётся и завершается один раз
    private final WorkerThread threads[];


    // список задач, чтобы соблюсти порядок выполнения задач, используем очередь.
    // т.е. это очередь задач
    private final Deque<Runnable> tasks;

    public ThreadPoolImpl(int threadsCount) {
        tasks = new LinkedList<>();
        // создали нужное кол-во потоков
        this.threads = new WorkerThread[threadsCount];

        // проходим по всем потокам
        for (int i = 0; i < threads.length; i++) {
            // и создаём из, задавая имя и номер
            threads[i] = new WorkerThread("poolWorker №: " + i);
            // и запускаем каждый поток
            threads[i].start();
        }
    }

    // вложенный класс для побочного потока
    private class WorkerThread extends Thread {
        public WorkerThread(String name) {
            // задал название потока
            super(name);
        }

        // а это по-сути consumer (потребитель)
        @Override
        public void run() {
            // взять задачу и выполнить её в одном из потоков пула, поскольку run - это действия в потоке workerThread
            // то каждая задачу будет выполнена именно в побочном потоке

            // текущая задача, которую необходимо выполнить
            Runnable currentTask;

            // поток работает workerThread бесконечно
            while (true) {
                // блокируем очередь задач
                synchronized (tasks) {
                    // пока очередь пустая
                    while (tasks.isEmpty()) {
                        // уходим в ожидание
                        try {
                            // workerThread ждёт пока не появятся новые задачи, т.е. вызова метода notify() на этом объекте
                            tasks.wait();
                        } catch (InterruptedException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                    // забрали очередную задачу
                    currentTask = tasks.poll();
                }
                // выполняем её
                // т.к. она уже в новом потоке, то вызываем через run()
                // когда потоков много, лучше сделать вне synchronized
                currentTask.run();
            }
        }
    }

    // по-сути это producer (поставщик задач)
    @Override
    public void submit(Runnable task) {
        // добавляем задачу в очередь
        // важно: когда добавляем задачу, то её нельзя оттуда забрать
        // для этого используем synchronize
        synchronized (tasks) {
            tasks.add(task);
            // как только задача появилась, нужно сообщить потоку workerThread
            // это модель wait-notify
            // когда выполниться notify, то проснётся какой-то из потоков, который на wait() и выполнит задачу
            task.notify();
        }
    }
}
