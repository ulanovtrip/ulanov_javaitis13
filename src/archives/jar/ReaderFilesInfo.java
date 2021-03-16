package archives.jar;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ReaderFilesInfo {
    public static void main(String[] args) {
        getInfo("/home/uis/Projects/ulanov_javaitis13/src/HomeWork1");
    }

    public static void getInfo(String directory) {
        File files = new File(directory);
        Map<String, Long> map = new HashMap<>();

        for (File file : files.listFiles()) {
            if (file.isFile()) {
                map.put(file.getName(), file.length());
            }
        }
        System.out.println(map.toString());
    }
}
