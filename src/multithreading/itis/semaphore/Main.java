package multithreading.itis.semaphore;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Main {

    public static void saveFile(String link) {
        try {
            saveFile0(link);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void saveFile0(String link) throws Exception {
        URL url = new URL(link);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // буфер для изображения
        byte[] buf = new byte[1024];
        int n = 0;
        // считывает блоки байтов в буфер
        while (-1 != (n = in.read(buf))) {
            // потом записывает этот буфер в out
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        // байтовое представление изображения
        byte[] response = out.toByteArray();

        String newFileName = UUID.randomUUID().toString();
        FileOutputStream outputStream = new FileOutputStream("images\\" + newFileName + ".png");
        outputStream.write(response);
        outputStream.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // с консоли укзываем сколько потоков можно запустить
        Semaphore semaphore = new Semaphore(scanner.nextInt()); // 10

        try {
            // читаем данные из файла, т.е. ссылки
            BufferedReader reader = new BufferedReader(new FileReader("/home/uis/Projects/ulanov_javaitis13/src/multithreading/itis/thread_classes/links.txt"));

            // для каждой линии(ссылки) из файла проходим и выполняем, т.е. для каждого файла
            reader.lines().forEach(fileName ->
                    // создаем новый поток
                    new Thread(() -> {
                        // в новом потоке выполняется это
                        try {
                            // этот метод занимает семафор, т.е. когда поток вызывает acquire, он уменьшает кол-во пермитов
                            semaphore.acquire();
                        } catch (InterruptedException e) {
                            throw new IllegalStateException(e);
                        }
                        System.out.println(Thread.currentThread().getName() + " начал скачивание");
                        // сохранение файла
                        saveFile(fileName);
                        System.out.println(Thread.currentThread().getName() + " скачал");
                        // это освобождает семафор, сразу после скачивания
                        semaphore.release();
                    }).start());
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
