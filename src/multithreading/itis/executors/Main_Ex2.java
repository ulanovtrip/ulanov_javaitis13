package multithreading.itis.executors;


import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;

public class Main_Ex2 {
    public static void saveFile(String link) throws Exception {
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
        System.out.println("FILE SAVED");
    }

    public static void main(String[] args) throws Exception {
        TaskExecutor executor = TaskExecutors.threadPool(10);

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        File file = new File("/home/uis/Projects/ulanov_javaitis13/src/links.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));


        String fileUrl = reader.readLine();
        while (fileUrl != null) {
            final String finalFileUrl = fileUrl;
            executor.submit(() -> {
                try {
                    saveFile(finalFileUrl);
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            });
//            scanner.nextLine();
            fileUrl = reader.readLine();
        }
    }
}
