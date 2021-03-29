package multithreading.itis.filesinfo.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class Informator {

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