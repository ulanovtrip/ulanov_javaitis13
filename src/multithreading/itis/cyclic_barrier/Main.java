package multithreading.itis.cyclic_barrier;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static double saveFile(String link) {
        try {
            return saveFile0(link);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static double saveFile0(String link) throws Exception {
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
        return response.length;
    }

    public static void main(String[] args) {
        // запоминаем размер каждого файла
        List<Double> filesSize = Collections.synchronizedList(new ArrayList<>());

        Scanner scanner = new Scanner(System.in);
        int parties = scanner.nextInt();

        // задача барьера отреагировать на завершение какого-либо parties-количества потоков
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, () -> {
            // считаем общий объем скачанных файлов на текущий момент
            double sum = filesSize.stream().mapToDouble(Double::doubleValue).sum();
            System.out.println("Скачано " + parties + " файлов, общий объем - " + sum + "  байтов");
        });

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/multithreading/itis/thread_classes/links.txt"));

            reader.lines().forEach(fileName -> new Thread(() -> {
                System.out.println(Thread.currentThread() + " начал скачивание");
                double bytes = saveFile(fileName);
                System.out.println(Thread.currentThread() + " завершил скачивание " + bytes + " байтов");
                // добавил размер текущего файла в список
                filesSize.add(bytes);
                // после того, как мы скачали, уводим текущий поток в ожидание, внутри cyclicBarrier
                try {
                    // увели текущий поток в ожидание
                    System.out.println(Thread.currentThread() + " ушел в ожидание");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println(Thread.currentThread() + " вышел из ожидания");
            }).start());
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
