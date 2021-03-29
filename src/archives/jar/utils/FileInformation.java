package archives.jar.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileInformation implements Runnable {

    private final String path;

    public FileInformation(String path) {
        this.path = path;
    }


    @Override
    public void run() {

        synchronized (path) {
            System.out.println("Folder name: " + path);
            File files = new File(path);
            Map<String, Long> map = new HashMap<>();
            for (File file : files.listFiles()) {
                if (file.isFile()) {
                    map.put(file.getName(), file.length());
                }
            }

            for (Map.Entry<String, Long> entry : map.entrySet()) {
                System.out.println("FileName: " + entry.getKey() + " --> FileSize: " + entry.getValue().toString());
            }

            System.out.println("--------------------------------");
        }
    }
}
